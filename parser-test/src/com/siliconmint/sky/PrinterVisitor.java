/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.siliconmint.sky;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

public class PrinterVisitor extends PsiElementVisitor {

  private final int identSize = 2;
  private int ident = 0;

  @Override
  public void visitElement(PsiElement element) {
    for (int i=0; i < ident; i++) {
      System.out.print(' ');
    }
    printElement(element);

    ident += 2;
    element.acceptChildren(this);
    ident -= 2;
  }

  protected void printElement(PsiElement element) {
    System.out.println(element.toString());
  }

}
