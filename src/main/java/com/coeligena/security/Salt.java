package com.coeligena.security;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 生成密码加密盐字符串
 *
 * Created by Ellery on 2017/9/12.
 */
@Component
class Salt {

    /**
     * 随机数种子偏移量
     */
    private static final int OFFSET = 675980;

    /**
     * 加密盐长度
     */
    private static final int SALT_BYTE_SIZE = 32;

    /**
     * 随机数种子
     */
    private long seed = System.currentTimeMillis() + OFFSET;

    /**
     * 生成加密盐
     *
     * @return 密码加密盐字节数组
     */
    byte[] generateSalt() {
        byte[] salt = new byte[SALT_BYTE_SIZE];

        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed);
            secureRandom.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return salt;
    }

    /**
     * 返回生成的密码加密盐字符串
     *
     * @return 密码加密盐字符串
     */
    String getSalt() {

        return toHex(this.generateSalt());
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

    /**
     * 字节数组转换为十六进制字符串
     *
     * @param array 待转换的字节数组
     * @return 字节数组编码成的十六进制字符串
     */
    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();

        if(paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        }
        return hex;
    }

}