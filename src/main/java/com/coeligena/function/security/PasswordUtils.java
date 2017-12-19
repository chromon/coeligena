package com.coeligena.function.security;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <P>
 *     密码处理类
 * </P>
 *
 * Created by Ellery on 2017/12/19.
 */
@Component
public class PasswordUtils {

    @Resource
    private Salt salt;

    /**
     * 由密码盐加密密码
     * @param srcPassword 原密码
     * @return 加密盐以及密码
     */
    public Map<String, String> getEncryptPassword(String srcPassword) {
        // 密码盐
        String passwordSalt = Encrypt.toHex(salt.getSalt());

        // 密码加密
        String passwordEncrypt = Encrypt.getDigest("SHA-256", srcPassword);
        String password = Encrypt.getDigest("SHA-256",
                passwordEncrypt + passwordSalt);
        Map<String, String> passMap = new HashMap<>();
        passMap.put("salt", passwordSalt);
        passMap.put("password", password);

        return passMap;
    }

    /**
     * 校验原密码到加密密码
     * @param salt 原加密盐
     * @param srcPassword 原密码
     * @return 加密后密码
     */
    public String checkPassword(String salt, String srcPassword) {

        String passwordEncrypt = Encrypt.getDigest("SHA-256", srcPassword);
        String password = Encrypt.getDigest("SHA-256",
                passwordEncrypt + salt);
        return password;
    }
}
