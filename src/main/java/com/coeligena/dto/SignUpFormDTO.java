package com.coeligena.dto;

import org.springframework.stereotype.Component;

/**
 * <p>
 *     注册表单 dto
 * </p>
 * Created by Ellery on 2017/12/16.
 */
public class SignUpFormDTO {

    private String fullName;

    private String email;

    private String signUpPassword;

    private String signUpCaptcha;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignUpPassword() {
        return signUpPassword;
    }

    public void setSignUpPassword(String signUpPassword) {
        this.signUpPassword = signUpPassword;
    }

    public String getSignUpCaptcha() {
        return signUpCaptcha;
    }

    public void setSignUpCaptcha(String signUpCaptcha) {
        this.signUpCaptcha = signUpCaptcha;
    }
}
