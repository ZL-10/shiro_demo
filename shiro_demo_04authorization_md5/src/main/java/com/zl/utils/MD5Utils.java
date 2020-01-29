package com.zl.utils;


import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Utils {

    public static void main(String[] args) {
        String source="123";

        Md5Hash hash1=new Md5Hash(source,"abc",2);
        String md51=hash1.toString();
        System.out.println("使用MD5加密后的"+ md51);

        Md5Hash hash2=new Md5Hash(source,"abc",2);
        System.out.println(hash2.toString());
        System.out.println(md51.equals(hash2.toString()));
    }
}
