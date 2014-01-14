
package com.siliconmint.ts.translator;

import com.intellij.psi.*;

public class NewExpressionTranslator extends Translator<PsiNewExpression> {

  @Override
  public void translate(PsiElementVisitor visitor, PsiNewExpression element, TranslationContext ctx) {


    boolean classDefinition = false;
    boolean arrayDefinition = false;
    String className = "";

    PsiJavaCodeReferenceElement classReference = element.getClassReference();
    PsiAnonymousClass anonymousClass = element.getAnonymousClass();
    if (classReference != null) {
      className = TypeHelper.getType(classReference);
    } else if (anonymousClass != null) {
      className = TypeHelper.getAnonymousClassType(anonymousClass);
      classDefinition = true;
    } else {
      className = TypeHelper.getType(element.getType().getDeepComponentType());
      arrayDefinition = true;
    }

    PsiExpression[] arrayDimensions = element.getArrayDimensions();
    PsiArrayInitializerExpression arrayInitializer = element.getArrayInitializer();
    if (arrayDimensions != null && arrayDimensions.length > 0) {
      arrayDefinition = true;
    }
    if (arrayInitializer != null) {
      arrayDefinition = true;
    }

    if (!arrayDefinition) {
      ctx.append("new ").append(className).append('(');

      if (element.getArgumentList() != null) {
          PsiExpression[] arguments = element.getArgumentList().getExpressions();
          for (int i=0; i < arguments.length; i++) {
            arguments[i].accept(visitor);
            if (i != arguments.length - 1) {
              ctx.append(", ");
            }
          }
      }
      ctx.append(')');

      if (classDefinition) {
        ctx.append("{\n");

        ctx.increaseIdent();
        anonymousClass.accept(visitor);
        ctx.decreaseIdent();

        ctx.print("}");
      }
    } else {
      if (arrayInitializer != null) {
        ctx.append("[");
        PsiExpression[] arrayInitializers = arrayInitializer.getInitializers();
        for (int i=0; i < arrayInitializers.length; i++) {
          arrayInitializers[i].accept(visitor);
          if (i != arrayInitializers.length - 1) {
            ctx.append(", ");
          }
        }
        ctx.append("]");
      } else {
        int dimensionCount = arrayDimensions.length;
        for (int i=0; i < dimensionCount; i++) {
          ctx.append("new Array(");
        }
        for (int i=0; i < dimensionCount; i++) {
          ctx.append(")");
        }
      }
    }
  }

}
