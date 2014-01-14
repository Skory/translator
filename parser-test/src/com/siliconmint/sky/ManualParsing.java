package com.siliconmint.sky;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.lang.java.JavaParserDefinition;
import com.intellij.lang.java.parser.JavaParser;
import com.intellij.lang.java.parser.JavaParserUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.psi.*;
import com.intellij.psi.impl.java.stubs.JavaStubElementTypes;
import com.intellij.psi.impl.source.PsiJavaFileImpl;
import com.intellij.psi.impl.source.tree.CoreJavaASTFactory;
import com.intellij.psi.impl.source.tree.LazyParseableElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.impl.source.tree.java.JavaFileElement;
import com.siliconmint.sky.mock.*;

import java.io.File;
import java.lang.reflect.Field;

public class ManualParsing {

  public static void main(String[] args) throws Exception {
    String text = FileUtil.loadFile(new File("/home/alexey/tmp/TestClass.java"));

    ApplicationManager.setApplication(new MockApplication(), new MockDisposable());
    LanguageASTFactory.INSTANCE.addExplicitExtension(JavaLanguage.INSTANCE, new CoreJavaASTFactory());
    LanguageParserDefinitions.INSTANCE.addExplicitExtension(JavaLanguage.INSTANCE, new JavaParserDefinition());

    Project project = new MockProject();
    PsiManager manager = new MockPsiManager(project);
    FileViewProvider fileViewProvider = new MockFileViewProvider(manager, text);

    JavaFileElement fileElement = new JavaFileElement(text);
    PsiJavaFileImpl psiJavaFile = new PsiJavaFileImpl(fileViewProvider);
    psiJavaFile.setTreeElementPointer(fileElement);
    fileElement.setPsi(psiJavaFile);

    PsiBuilder builder = JavaParserUtil.createBuilder(fileElement);
    PsiBuilder.Marker root = builder.mark();
    JavaParser.INSTANCE.getFileParser().parse(builder);
    root.done(JavaStubElementTypes.JAVA_FILE);

    ASTNode treeBuilt = builder.getTreeBuilt();

    Field textField = LazyParseableElement.class.getDeclaredField("myText");
    textField.setAccessible(true);
    textField.set(fileElement, null);

    fileElement.rawAddChildrenWithoutNotifications((TreeElement) treeBuilt.getFirstChildNode());

    fileElement.getPsi().accept(new PrinterVisitor());
  }

}
