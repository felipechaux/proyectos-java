/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suprema.ufe33;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public abstract interface UFScannerClass$UFS_CAPTURE_PROC
  extends Callback
{
  public abstract int callback(Pointer paramPointer1, int paramInt1, Pointer paramPointer2, int paramInt2, int paramInt3, int paramInt4, PointerByReference paramPointerByReference);
}