package com.coeligena.function.security;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用加密盐对密码进行加密
 *
 * <p>
 * Created by Ellery on 2017/9/14.
 */
@Component
public class Encrypt {

    /**
     * 消息摘要算法
     *
     * @param type 消息摘要算法类型 MD5、SHA、SHA-256、SHA-384、SHA-512
     * @param text 待加密消息字符串
     * @return 生成的摘要字节数组
     */
    private static byte[] generateDigest(String type, String text) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(type);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md.digest(text.getBytes());
    }

    /**
     * 获取生成的摘要
     *
     * @param type 消息摘要算法类型 MD5、SHA、SHA-256、SHA-384、SHA-512
     * @param text 待加密消息字符串
     * @return 生成的摘要字符串
     */
    public static String getDigest(String type, String text) {
        return toHex(generateDigest(type, text));
    }

    /**
     * 字节数组转换为十六进制字符串
     *
     * @param array 待转换的字节数组
     * @return 字节数组编码成的十六进制字符串
     */
    public static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();

        if(paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        }
        return hex;
    }

    /**
     * 十六进制字符串转换为字节数组
     *
     * @param hex 十六进制字符串
     * @return 十六进制字符串解码成的字节数组
     */
    private static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];

        for(int i = 0; i < binary.length; i++) {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }

        return binary;
    }
}
