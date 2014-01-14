package com.siliconmint.sky;

import com.intellij.core.JavaCoreApplicationEnvironment;
import com.intellij.core.JavaCoreProjectEnvironment;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.lang.TokenWrapper;
import com.intellij.lang.java.JavaParserDefinition;
import com.intellij.lexer.Lexer;
import com.intellij.mock.MockProject;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.tree.IElementType;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ParserRunner
{
  public static void main(String[] args) throws IOException
  {
    String JAVA_SOURCE = loadFileText(new File("/home/alexey/dev/projects/sky/skycode/idea-mini/parser-test/src/com/siliconmint/sky/ParserRunner.java"));

    // Example: create & run lexer
    createJavaLexer(JAVA_SOURCE);

    PsiFileFactory psiFileFactory = createPsiFactory();

    Collection<File> javaSources = getJavaSources("/home/alexey/dev/projects/sky/skycode/idea-mini/parser-test/src/com/siliconmint/sky");
    for( File javaFile : javaSources )
    {
      long t0 = System.currentTimeMillis();
      String javaSource = FileUtil.loadFile(javaFile);
      parseJavaSource(javaSource, psiFileFactory);
      long t1 = System.currentTimeMillis();
      System.out.println("parse time (ms):  " + (t1-t0) + " size: " + javaSource.length() + javaFile.getAbsolutePath());
    }

    FileASTNode node = parseJavaSource(JAVA_SOURCE, psiFileFactory);
    printAST(0, node);
  }

  private static PsiFileFactory createPsiFactory()
  {
    MockProject mockProject = createProject();
    //PsiElementFactory psiElementFactory = JavaPsiFacade.getElementFactory(mockProject);
    return PsiFileFactory.getInstance(mockProject);
  }

  private static MockProject createProject()
  {
    JavaCoreProjectEnvironment environment = new JavaCoreProjectEnvironment(new Disposable()
    {
        @Override
        public void dispose()
        {
        }
        }, new JavaCoreApplicationEnvironment(new Disposable()
        {
        @Override
        public void dispose(){}
    }));

    return environment.getProject();
  }

  private static FileASTNode parseJavaSource(String JAVA_SOURCE, PsiFileFactory psiFileFactory)
  {
    PsiFile psiFile = psiFileFactory.createFileFromText("__dummy_file__.java", JavaFileType.INSTANCE, JAVA_SOURCE);
    PsiJavaFile psiJavaFile = (PsiJavaFile) psiFile;
    return psiJavaFile.getNode();
  }

  private static void createJavaLexer(String JAVA_SOURCE)
  {
    Lexer lexer = JavaParserDefinition.createLexer(LanguageLevel.HIGHEST);
    lexer.start(JAVA_SOURCE);
    String tokensAsString = toTokenString(lexer);
    System.out.println("tokens: " + tokensAsString);
  }

  private static Collection<File> getJavaSources(String path)
  {
    ArrayList<File> javaSources = new ArrayList<File>();
    getJavaSourcesHelper(new File(path), javaSources);
    return javaSources;
  }

  private static void getJavaSourcesHelper(File dir, Collection<File> javaSources)
  {
    File[] files = dir.listFiles();

    for( int i = 0; i < files.length; i++ )
    {
      File file = files[i];

      if( !file.isDirectory() && file.getName().endsWith(".java") )
        javaSources.add(file);
      else if( file.isDirectory() )
        getJavaSourcesHelper(file, javaSources);
    }
  }

  private static void printAST(int indent, ASTNode node)
  {
    ASTNode[] children = node.getChildren(null);
    for( int i = 0; i < children.length; i++ )
    {
      ASTNode child = children[i];

      for( int j = 0; j < indent; j++ )
        System.out.print("\t");

      System.out.println(child);

      printAST(indent+1, child);
    }
  }

  private static String toTokenString(Lexer lexer)
  {
    String result = "";
    while( true )
    {
      IElementType tokenType = lexer.getTokenType();
      if( tokenType == null )
      {
        break;
      }
      String tokenText = getTokenText(lexer);
      String tokenTypeName = tokenType.toString();
      String line = tokenTypeName + " ('" + tokenText + "')\n";
      result += line;
      lexer.advance();
    }

    return result;
  }

  private static String getTokenText(Lexer lexer)
  {
    final IElementType tokenType = lexer.getTokenType();
    if( tokenType instanceof TokenWrapper )
    {
      return ((TokenWrapper) tokenType).getValue();
    }

    String text = lexer.getBufferSequence().subSequence(lexer.getTokenStart(), lexer.getTokenEnd()).toString();
    //text = StringUtil.replace(text, "\n", "\\n");
    text = text.replaceAll("\n","\\n");
    return text;
  }


  public static String loadFileText(@NotNull File file) throws IOException {
    return new String(loadFileText(file, null));
  }

  @NotNull
  public static char[] loadFileText(@NotNull File file, @Nullable String encoding) throws IOException {
    InputStream stream = new FileInputStream(file);
    @SuppressWarnings("IOResourceOpenedButNotSafelyClosed")
    Reader reader = encoding == null ? new InputStreamReader(stream) : new InputStreamReader(stream, encoding);
    try {
      return loadText(reader, (int)file.length());
    }
    finally {
      reader.close();
    }
  }

  @NotNull
  public static char[] loadText(@NotNull Reader reader, int length) throws IOException {
    char[] chars = new char[length];
    int count = 0;
    while (count < chars.length) {
      int n = reader.read(chars, count, chars.length - count);
      if (n <= 0) break;
      count += n;
    }
    if (count == chars.length) {
      return chars;
    }
    else {
      char[] newChars = new char[count];
      System.arraycopy(chars, 0, newChars, 0, count);
      return newChars;
    }
  }
}
