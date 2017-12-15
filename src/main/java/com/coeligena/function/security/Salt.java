package com.coeligena.function.security;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 生成密码加密盐字符串
 *
 * <p>
 * Created by Ellery on 2017/9/12.
 */
@Component
public class Salt {

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
    private byte[] generateSalt() {
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
    public byte[] getSalt() {
        return this.generateSalt();
    }

}