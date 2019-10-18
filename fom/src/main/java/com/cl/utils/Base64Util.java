package com.cl.utils;

import java.util.Base64;

/**
 * @Description: base64工具类
 * @Author: liugenhua
 * @Date created in 2018/5/18 12:03
 */
public class Base64Util {
	
    public static String encode(byte[] bs){
       return Base64.getEncoder().encodeToString(bs);
    }

    public static byte[] decode(String str){
        return Base64.getDecoder().decode(str);
    }
}
