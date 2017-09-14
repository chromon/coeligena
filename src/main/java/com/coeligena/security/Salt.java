package com.coeligena.security;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 生成密码加密盐字符串
 *
 * Created by Ellery on 2017/9/12.
 */
@Component
public class Salt {

    protected String getSalt() {
        int OFFSET = 675980;
        long seed = System.currentTimeMillis() + OFFSET;

        // 安全随机类
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 验证码数字取值范围
        String codeList = "abcdef1234567890";
        // 定义一个验证码字符串变量
        String salt = new String("");

        for (int i = 0; i < 64; i++) {
            // 随即生成一个整数
            int code = secureRandom.nextInt(codeList.length() - 1);
            String rand = codeList.substring(code, code + 1);
            // 将生成的随机数拼成一个64位数验证码
            salt += rand;
        }

        return salt;
    }

}
