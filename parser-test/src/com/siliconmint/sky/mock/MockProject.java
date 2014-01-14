package com.siliconmint.sky.mock;

import com.intellij.core.CoreLanguageLevelProjectExtension;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.CachedValuesManagerImpl;
import com.intellij.util.messages.MessageBus;
import org.picocontainer.PicoContainer;

public class MockProject extends UserDataHolderBase implements Project {

  private MockContainer container = new MockContainer();
  {
    container.setComponentInstance("com.intellij.psi.util.CachedValuesManager",
        new CachedValuesManagerImpl(this, null));
    container.setComponentInstance("com.intellij.openapi.roots.LanguageLevelProjectExtension",
        new CoreLanguageLevelProjectExtension());
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public VirtualFile getBaseDir() {
    return null;
  }

  @Override
  public String getBasePath() {
    return null;
  }

  @Override
  public VirtualFile getProjectFile() {
    return null;
  }

  @Override
  public String getProjectFilePath() {
    return null;
  }

  @Override
  public String getPresentableUrl() {
    return null;
  }

  @Override
  public VirtualFile getWorkspaceFile() {
    return null;
  }

  @Override
  public String getLocationHash() {
    return null;
  }

  @Override
  public String getLocation() {
    return null;
  }

  @Override
  public void save() {

  }

  @Override
  public boolean isOpen() {
    return false;
  }

  @Override
  public boolean isInitialized() {
    return false;
  }

  @Override
  public boolean isDefault() {
    return false;
  }

  @Override
  public BaseComponent getComponent(String name) {
    return null;
  }

  @Override
  public <T> T getComponent(Class<T> interfaceClass) {
    return null;
  }

  @Override
  public <T> T getComponent(Class<T> interfaceClass, T defaultImplementationIfAbsent) {
    return null;
  }

  @Override
  public boolean hasComponent(Class interfaceClass) {
    return false;
  }

  @Override
  public <T> T[] getComponents(Class<T> baseClass) {
    return null;
  }

  @Override
  public PicoContainer getPicoContainer() {
    return container;
  }

  @Override
  public MessageBus getMessageBus() {
    return null;
  }

  @Override
  public boolean isDisposed() {
    return false;
  }

  @Override
  public <T> T[] getExtensions(ExtensionPointName<T> extensionPointName) {
    return null;
  }

  @Override
  public Condition getDisposed() {
    return null;
  }

  @Override
  public void dispose() {

  }

}