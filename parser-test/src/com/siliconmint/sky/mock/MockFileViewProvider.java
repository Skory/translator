package com.siliconmint.sky.mock;

import com.intellij.lang.Language;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MockFileViewProvider implements FileViewProvider, Cloneable {

  private String text;
  private PsiManager manager;
  private VirtualFile file = new MockVirtualFile();

  public MockFileViewProvider(PsiManager manager, String text) {
    this.text = text;
    this.manager = manager;
  }

  @Override
  public PsiManager getManager() {
    return manager;
  }

  @Override
  public Document getDocument() {
    return null;
  }

  @Override
  public CharSequence getContents() {
    return text;
  }

  @Override
  public VirtualFile getVirtualFile() {
    return file;
  }

  @Override
  public Language getBaseLanguage() {
    return JavaLanguage.INSTANCE;
  }

  @Override
  public Set<Language> getLanguages() {
    return Collections.singleton(getBaseLanguage());
  }

  @Override
  public PsiFile getPsi(Language target) {
    return null;
  }

  @Override
  public List<PsiFile> getAllFiles() {
    return null;
  }

  @Override
  public boolean isEventSystemEnabled() {
    return false;
  }

  @Override
  public boolean isPhysical() {
    return false;
  }

  @Override
  public long getModificationStamp() {
    return 0;
  }

  @Override
  public boolean supportsIncrementalReparse(Language rootLanguage) {
    return false;
  }

  @Override
  public void rootChanged(PsiFile psiFile) {

  }

  @Override
  public void beforeContentsSynchronized() {

  }

  @Override
  public void contentsSynchronized() {

  }

  @Override
  public FileViewProvider clone() {
    try {
      return (FileViewProvider) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public PsiElement findElementAt(int offset) {
    return null;
  }

  @Override
  public PsiReference findReferenceAt(int offset) {
    return null;
  }

  @Override
  public PsiElement findElementAt(int offset, Language language) {
    return null;
  }

  @Override
  public PsiElement findElementAt(int offset, Class<? extends Language> lang) {
    return null;
  }

  @Override
  public PsiReference findReferenceAt(int offsetInElement, Language language) {
    return null;
  }

  @Override
  public FileViewProvider createCopy(VirtualFile copy) {
    return null;
  }

  @Override
  public PsiFile getStubBindingRoot() {
    return null;
  }

  @Override
  public <T> T getUserData(Key<T> key) {
    return null;
  }

  @Override
  public <T> void putUserData(Key<T> key, T value) {
  }
}
