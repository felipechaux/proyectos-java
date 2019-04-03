package com.suprema.ufe33;

public class BioMiniJniSDK { public BioMiniJniSDK() {}
  
  public native int UFS_Init();
  public native int UFS_Update();
  public native int UFS_Uninit();
  public final int UFS_OK = 0;
  public final int UFS_STATUS = 0;
  public final int UFS_ERROR = -1;
  public final int UFS_ERR_NO_LICENSE = -101;
  public final int UFS_ERR_LICENSE_NOT_MATCH = -102;
  public final int UFS_ERR_LICENSE_EXPIRED = -103;
  public final int UFS_ERR_NOT_SUPPORTED = -111;
  public final int UFS_ERR_INVALID_PARAMETERS = -112;
  
  public final int UFS_ERR_ALREADY_INITIALIZED = 65335;
  public final int UFS_ERR_NOT_INITIALIZED = 65334;
  public final int UFS_ERR_DEVICE_NUMBER_EXCEED = 65333;
  public final int UFS_ERR_LOAD_SCANNER_LIBRARY = 65332;
  public final int UFS_ERR_CAPTURE_RUNNING = 65325;
  public final int UFS_ERR_CAPTURE_FAILED = 65324;
  public final int UFS_ERR_FAKE_FINGER = 65315;
  public final int UFS_ERR_FINGER_ON_SENSOR = 65305;
  
  public final int UFS_ERR_NOT_GOOD_IMAGE = 65235;
  public final int UFS_ERR_EXTRACTION_FAILED = 65234;
  
  public final int UFS_ERR_CORE_NOT_DETECTED = 65185;
  public final int UFS_ERR_CORE_TO_LEFT = 65184;
  public final int UFS_ERR_CORE_TO_LEFT_TOP = 65183;
  public final int UFS_ERR_CORE_TO_TOP = 65182;
  public final int UFS_ERR_CORE_TO_RIGHT_TOP = 65181;
  public final int UFS_ERR_CORE_TO_RIGHT = 65180;
  public final int UFS_ERR_CORE_TO_RIGHT_BOTTOM = 65179;
  public final int UFS_ERR_CORE_TO_BOTTOM = 65178;
  public final int UFS_ERR_CORE_TO_LEFT_BOTTOM = 65177;
  public native int UFS_SetScannerCallback(String paramString);
  public native int UFS_RemoveScannerCallback();
  public native int UFS_SetClassName(String paramString);
  public final int UFS_PARAM_TIMEOUT = 201;
  public final int UFS_PARAM_BRIGHTNESS = 202;
  public final int UFS_PARAM_SENSITIVITY = 203;
  public final int UFS_PARAM_SERIAL = 204;
  
  public final int UFS_PARAM_DETECT_CORE = 301;
  public final int UFS_PARAM_TEMPLATE_SIZE = 302;
  public final int UFS_PARAM_USE_SIF = 311;
  public final int UFS_PARAM_CHECK_ENROLL_QUALITY = 321;
  
  public final int UFS_PARAM_DETECT_FAKE = 312;
  

  public final int UFS_SCANNER_TYPE_SFR200 = 1001;
  public final int UFS_SCANNER_TYPE_SFR300 = 1002;
  public final int UFS_SCANNER_TYPE_SFR300v2 = 1003;
  public final int UFS_SCANNER_TYPE_SFR500 = 1004;
  public native int UFS_GetScannerNumber(int[] paramArrayOfInt);
  public native int UFS_GetScannerHandle(int paramInt, long[] paramArrayOfLong);
  public native int UFS_GetScannerHandleByID(String paramString, long[] paramArrayOfLong);
  public native int UFS_GetScannerIndex(long paramLong, int[] paramArrayOfInt);
  public native int UFS_GetScannerID(long paramLong, byte[] paramArrayOfByte);
  public native int UFS_GetCompanyID(long paramLong, byte[] paramArrayOfByte); public final int UFS_TEMPLATE_TYPE_SUPREMA = 2001;
  public native int UFS_GetScannerType(long paramLong, int[] paramArrayOfInt); public native int UFS_GetParameter(long paramLong, int paramInt, int[] paramArrayOfInt); public native int UFS_SetParameter(long paramLong, int paramInt, int[] paramArrayOfInt); public final int UFS_TEMPLATE_TYPE_ISO19794_2 = 2002;
  public native int UFS_IsSensorOn(long paramLong, int[] paramArrayOfInt); public native int UFS_IsFingerOn(long paramLong, int[] paramArrayOfInt); public final int UFS_TEMPLATE_TYPE_ANSI378 = 2003;
  public native int UFS_CaptureSingleImage(long paramLong);
  public native int UFS_StartCapturing(long paramLong, String paramString);
  public native int UFS_IsCapturing(long paramLong, int[] paramArrayOfInt);
  public native int UFS_AbortCapturing(long paramLong); public native int UFS_Extract(long paramLong, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2); public final int UFMOK = 0;
  public native int UFS_SetEncryptionKey(long paramLong, byte[] paramArrayOfByte);
  public native int UFS_EncryptTemplate(long paramLong, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, int[] paramArrayOfInt); public native int UFS_DecryptTemplate(long paramLong, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, int[] paramArrayOfInt); public native int UFS_GetCaptureImageBufferInfo(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3); public final int UFMERROR = -1;
  public final int UFMERR_NO_LICENSE = -101;
  public final int UFMERR_LICENSE_NOT_MATCH = -102;
  public final int UFMERR_LICENSE_EXPIRED = -103;
  public final int UFMERR_NOT_SUPPORTED = -111;
  public final int UFMERR_INVALID_PARAMETERS = -112;
  public native int UFS_GetCaptureImageBuffer(long paramLong, byte[] paramArrayOfByte);
  public native int UFS_SaveCaptureImageBufferToBMP(long paramLong, String paramString);
  public native int UFS_SaveCaptureImageBufferTo19794_4(long paramLong, String paramString); public final int UFM_ERR_MATCH_TIMEOUT = 65135;
  public final int UFM_ERR_MATCH_ABORTED = 65134;
  public final int UFM_ERR_TEMPLATE_TYPE = 65125;
  public native int UFS_ClearCaptureImageBuffer(long paramLong);
  public native int UFS_SaveCaptureImageBufferToWSQ(long paramLong, float paramFloat, String paramString); public native int UFS_GetFeatureNumber(long paramLong, byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt); public native int UFS_GetErrorString(int paramInt, byte[] paramArrayOfByte); public native int UFS_SetTemplateType(long paramLong, int paramInt); public final int UFM_PARAM_FAST_MODE = 301;
  public final int UFM_PARAM_SECURITY_LEVEL = 302;
  public final int UFM_PARAM_USE_SIF = 311;
  
  public native int UFS_GetTemplateType(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_SelectTemplate(long paramLong, byte[][] paramArrayOfByte1, int[] paramArrayOfInt1, int paramInt1, byte[][] paramArrayOfByte2, int[] paramArrayOfInt2, int paramInt2);
  
  public native int UFM_Create(long[] paramArrayOfLong);
  
  public native int UFM_Delete(long paramLong);
  
  public native int UFM_GetParameter(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  public native int UFM_SetParameter(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  public native int UFM_Verify(long paramLong, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int[] paramArrayOfInt);
  
  public final int UFM_TEMPLATE_TYPE_SUPREMA = 2001;
  
  public native int UFM_Identify(long paramLong, byte[] paramArrayOfByte, int paramInt1, byte[][] paramArrayOfByte1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2);
  
  public native int UFM_IdentifyMT(long paramLong, byte[] paramArrayOfByte, int paramInt1, byte[][] paramArrayOfByte1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2);
  
  public native int UFM_AbortIdentify(long paramLong);
  
  public final int UFM_TEMPLATE_TYPE_ISO19794_2 = 2002;
  public native int UFM_IdentifyInit(long paramLong, byte[] paramArrayOfByte, int paramInt); public native int UFM_IdentifyNext(long paramLong, byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt); public native int UFM_RotateTemplate(long paramLong, byte[] paramArrayOfByte, int paramInt); public final int UFM_TEMPLATE_TYPE_ANSI378 = 2003;
  public native int UFM_GetErrorString(int paramInt, byte[] paramArrayOfByte);
  public native int UFM_SetTemplateType(long paramLong, int paramInt);
  public native int UFM_GetTemplateType(long paramLong, int[] paramArrayOfInt); static { System.loadLibrary("BioMiniJniSDK"); }
}