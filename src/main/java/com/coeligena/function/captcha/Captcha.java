package com.coeligena.function.captcha;

import com.github.bingoohuang.patchca.color.SingleColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 验证码
 *
 * <p>
 * Created by Ellery on 2017/11/11.
 */
public class Captcha {

    public static void main(String[] args) {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

        try {
            FileOutputStream fos = new FileOutputStream("patcha_demo.png");
            EncoderHelper.getChallangeAndWriteImage(cs, "png", fos);
            fos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(cs.getCaptcha().getChallenge());
    }
}
