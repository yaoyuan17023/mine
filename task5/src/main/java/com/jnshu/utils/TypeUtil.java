package com.jnshu.utils;

/**
 * created by 姚远 on 2017/9/11.
 */
public class TypeUtil {

    //把16进制字符串转换成字节数组，
    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }
    public static byte[] hexStringToByte(String hex){
        int len = (hex.length()/2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0 ; i < len ; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 |toByte(achar[pos + 1]));
        }
        return result;
    }
    //把字节数组转换成16进制字符串
    public static String bytesToHexString(byte[] Array) {
        StringBuffer sb = new StringBuffer(Array.length);
        String sTemp;
        for (int i = 0; i <Array.length; i++) {
            sTemp = Integer.toHexString( 0xFF & Array[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    //测试
    public static  void main(String[] args){
        String str = "1246AB";
        System.out.println(bytesToHexString(hexStringToByte(str)));
    }
}
