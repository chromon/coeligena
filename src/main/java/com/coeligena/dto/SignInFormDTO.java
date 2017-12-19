package com.coeligena.dto;

/**
 * <p>
 *     登录 form 数据传输对象
 * </p>
 *
 * Created by Ellery on 2017/12/19.
 */
public class SignInFormDTO {

    private String account;

    private String signInPassword;

    private String signInCaptcha;

    private String smsCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSignInPassword() {
        return signInPassword;
    }

    public void setSignInPassword(String signInPassword) {
        this.signInPassword = signInPassword;
    }

    public String getSignInCaptcha() {
        return signInCaptcha;
    }

    public void setSignInCaptcha(String signInCaptcha) {
        this.signInCaptcha = signInCaptcha;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
