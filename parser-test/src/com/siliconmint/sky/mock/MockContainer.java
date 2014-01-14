package com.siliconmint.sky.mock;

import com.intellij.util.containers.HashMap;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVerificationException;
import org.picocontainer.PicoVisitor;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MockContainer implements PicoContainer {

  private Map<String, Object> components = new HashMap<String, Object>();

  @Override
  public Object getComponentInstance(Object o) {
    return components.get(o.toString());
  }

  public void setComponentInstance(String name, Object component){
    components.put(name, component);
  }

  @Override
  public Object getComponentInstanceOfType(Class aClass) {
    return null;
  }

  @Override
  public List getComponentInstances() {
    return null;
  }

  @Override
  public PicoContainer getParent() {
    return null;
  }

  @Override
  public ComponentAdapter getComponentAdapter(Object o) {
    return null;
  }

  @Override
  public ComponentAdapter getComponentAdapterOfType(Class aClass) {
    return null;
  }

  @Override
  public Collection getComponentAdapters() {
    return null;
  }

  @Override
  public List getComponentAdaptersOfType(Class aClass) {
    return null;
  }

  @Override
  public void verify() throws PicoVerificationException {

  }

  @Override
  public List getComponentInstancesOfType(Class aClass) {
    return null;
  }

  @Override
  public void accept(PicoVisitor picoVisitor) {

  }

  @Override
  public void dispose() {

  }

  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }
}
