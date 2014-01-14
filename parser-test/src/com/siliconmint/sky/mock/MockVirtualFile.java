package com.siliconmint.sky.mock;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MockVirtualFile extends VirtualFile {
  @Override
  public String getName() {
    return "__dummy__";
  }

  @Override
  public VirtualFileSystem getFileSystem() {
    return null;
  }

  @Override
  public String getPath() {
    return null;
  }

  @Override
  public boolean isWritable() {
    return true;
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public VirtualFile getParent() {
    return null;
  }

  @Override
  public VirtualFile[] getChildren() {
    return null;
  }

  @Override
  public OutputStream getOutputStream(Object requestor, long newModificationStamp, long newTimeStamp) throws IOException {
    return null;
  }

  @Override
  public byte[] contentsToByteArray() throws IOException {
    return new byte[0];
  }

  @Override
  public long getTimeStamp() {
    return 0;
  }

  @Override
  public long getLength() {
    return 0;
  }

  @Override
  public void refresh(boolean asynchronous, boolean recursive, Runnable postRunnable) {

  }

  @Override
  public InputStream getInputStream() throws IOException {
    return null;
  }
}
