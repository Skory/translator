package com.siliconmint.sky.mock;

import com.intellij.core.CoreASTFactory;
import com.intellij.lang.DefaultASTFactory;
import com.intellij.lang.impl.PsiBuilderFactoryImpl;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.*;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.ThrowableComputable;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.util.messages.MessageBus;
import org.picocontainer.PicoContainer;

import java.awt.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class MockApplication extends UserDataHolderBase implements Application {

  private MockContainer container = new MockContainer();
  {
    container.setComponentInstance("com.intellij.lang.PsiBuilderFactory", new PsiBuilderFactoryImpl());
    container.setComponentInstance("com.intellij.lang.DefaultASTFactory", new CoreASTFactory());
  }

  @Override
  public void runReadAction(Runnable action) {

  }

  @Override
  public <T> T runReadAction(Computable<T> computation) {
    return null;
  }

  @Override
  public <T, E extends Throwable> T runReadAction(ThrowableComputable<T, E> computation) throws E {
    return null;
  }

  @Override
  public void runWriteAction(Runnable action) {

  }

  @Override
  public <T> T runWriteAction(Computable<T> computation) {
    return null;
  }

  @Override
  public <T, E extends Throwable> T runWriteAction(ThrowableComputable<T, E> computation) throws E {
    return null;
  }

  @Override
  public boolean hasWriteAction(Class<?> actionClass) {
    return false;
  }

  @Override
  public void assertReadAccessAllowed() {

  }

  @Override
  public void assertWriteAccessAllowed() {

  }

  @Override
  public void assertIsDispatchThread() {

  }

  @Override
  public void addApplicationListener(ApplicationListener listener) {

  }

  @Override
  public void addApplicationListener(ApplicationListener listener, Disposable parent) {

  }

  @Override
  public void removeApplicationListener(ApplicationListener listener) {

  }

  @Override
  public void saveAll() {

  }

  @Override
  public void saveSettings() {

  }

  @Override
  public void exit() {

  }

  @Override
  public boolean isWriteAccessAllowed() {
    return true;
  }

  @Override
  public boolean isReadAccessAllowed() {
    return true;
  }

  @Override
  public boolean isDispatchThread() {
    return false;
  }

  @Override
  public ModalityInvokator getInvokator() {
    return null;
  }

  @Override
  public void invokeLater(Runnable runnable) {

  }

  @Override
  public void invokeLater(Runnable runnable, Condition expired) {

  }

  @Override
  public void invokeLater(Runnable runnable, ModalityState state) {

  }

  @Override
  public void invokeLater(Runnable runnable, ModalityState state, Condition expired) {

  }

  @Override
  public void invokeAndWait(Runnable runnable, ModalityState modalityState) {

  }

  @Override
  public ModalityState getCurrentModalityState() {
    return null;
  }

  @Override
  public ModalityState getModalityStateForComponent(Component c) {
    return null;
  }

  @Override
  public ModalityState getDefaultModalityState() {
    return null;
  }

  @Override
  public ModalityState getNoneModalityState() {
    return null;
  }

  @Override
  public ModalityState getAnyModalityState() {
    return null;
  }

  @Override
  public long getStartTime() {
    return 0;
  }

  @Override
  public long getIdleTime() {
    return 0;
  }

  @Override
  public boolean isUnitTestMode() {
    return false;
  }

  @Override
  public boolean isHeadlessEnvironment() {
    return false;
  }

  @Override
  public boolean isCommandLine() {
    return false;
  }

  @Override
  public boolean isDisposed() {
    return false;
  }

  @Override
  public Future<?> executeOnPooledThread(Runnable action) {
    return null;
  }

  @Override
  public <T> Future<T> executeOnPooledThread(Callable<T> action) {
    return null;
  }

  @Override
  public boolean isDisposeInProgress() {
    return false;
  }

  @Override
  public boolean isRestartCapable() {
    return false;
  }

  @Override
  public void restart() {

  }

  @Override
  public boolean isActive() {
    return false;
  }

  @Override
  public AccessToken acquireReadActionLock() {
    return null;
  }

  @Override
  public AccessToken acquireWriteActionLock(Class marker) {
    return null;
  }

  @Override
  public boolean isInternal() {
    return false;
  }

  @Override
  public boolean isEAP() {
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
  public <T> T[] getExtensions(ExtensionPointName<T> extensionPointName) {
    return null;
  }

  @Override
  public Condition getDisposed() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void dispose() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
