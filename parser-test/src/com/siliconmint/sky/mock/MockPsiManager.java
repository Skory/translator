package com.siliconmint.sky.mock;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.PsiManagerEx;
import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.impl.file.impl.FileManager;
import com.intellij.psi.util.PsiModificationTracker;

public class MockPsiManager extends PsiManagerEx {

  private Project project;

  public MockPsiManager(Project project) {
    this.project = project;
  }

  @Override
  public Project getProject() {
    return project;
  }

  @Override
  public boolean isBatchFilesProcessingMode() {
    return false;
  }

  @Override
  public boolean isAssertOnFileLoading(VirtualFile file) {
    return false;
  }

  @Override
  public void registerRunnableToRunOnChange(Runnable runnable) {

  }

  @Override
  public void registerRunnableToRunOnAnyChange(Runnable runnable) {

  }

  @Override
  public void registerRunnableToRunAfterAnyChange(Runnable runnable) {

  }

  @Override
  public FileManager getFileManager() {
    return null;
  }

  @Override
  public void beforeChildAddition(PsiTreeChangeEventImpl event) {

  }

  @Override
  public void beforeChildRemoval(PsiTreeChangeEventImpl event) {

  }

  @Override
  public void beforeChildReplacement(PsiTreeChangeEventImpl event) {

  }

  @Override
  public void beforeChange(boolean isPhysical) {

  }

  @Override
  public void afterChange(boolean isPhysical) {

  }

  @Override
  public PsiFile findFile(VirtualFile file) {
    return null;
  }

  @Override
  public FileViewProvider findViewProvider(VirtualFile file) {
    return null;
  }

  @Override
  public PsiDirectory findDirectory(VirtualFile file) {
    return null;
  }

  @Override
  public boolean areElementsEquivalent(PsiElement element1, PsiElement element2) {
    return false;
  }

  @Override
  public void reloadFromDisk(PsiFile file) {

  }

  @Override
  public void addPsiTreeChangeListener(PsiTreeChangeListener listener) {

  }

  @Override
  public void addPsiTreeChangeListener(PsiTreeChangeListener listener, Disposable parentDisposable) {

  }

  @Override
  public void removePsiTreeChangeListener(PsiTreeChangeListener listener) {

  }

  @Override
  public PsiModificationTracker getModificationTracker() {
    return null;
  }

  @Override
  public void startBatchFilesProcessingMode() {

  }

  @Override
  public void finishBatchFilesProcessingMode() {

  }

  @Override
  public boolean isDisposed() {
    return false;
  }

  @Override
  public void dropResolveCaches() {

  }

  @Override
  public boolean isInProject(PsiElement element) {
    return false;
  }
}
