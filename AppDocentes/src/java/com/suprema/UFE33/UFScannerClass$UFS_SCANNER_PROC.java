package com.suprema.ufe33;

import com.sun.jna.Callback;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCall;

public abstract interface UFScannerClass$UFS_SCANNER_PROC
  extends Callback, StdCall
{
  public abstract int callback(String paramString, int paramInt, PointerByReference paramPointerByReference);
}