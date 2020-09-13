package com.sily.dhwdemo.glide;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String toMD5(String key) {
        if (digest == null) {
            return String.valueOf(key.hashCode());
        }
        digest.update(key.getBytes());
        return conver2HexString(digest.digest());
    }

    private static String conver2HexString(byte[] digest) {
    StringBuffer sb=new StringBuffer();
        for (byte b : digest) {
            String hex=Integer.toHexString(0xFF &b);
            if(hex.length()==1){
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
