/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Hugo
 */
public class EncryptUtil {

    public static String toSHA1(String text) {
        byte[] digest, buffer;
        MessageDigest md = null;

        try {
            buffer = text.getBytes("UTF-8");
            md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(buffer);

            digest = md.digest();

            String hash = "";
            for (byte aux : digest) {
                int b = aux & 0xff;
                if (Integer.toHexString(b).length() == 1) {
                    hash += "0";
                }
                hash += Integer.toHexString(b);
            }

            return hash;
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    public static String md5(String clear){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(clear.getBytes());
            
            int size = b.length;
            StringBuffer h = new StringBuffer(size);
            for (int i = 0; i < size; i++) {
                int u = b[i] & 255;
                if (u < 16) {
                    h.append("0" + Integer.toHexString(u));
                } else {
                    h.append(Integer.toHexString(u));
                }
            }
            return h.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }
}
