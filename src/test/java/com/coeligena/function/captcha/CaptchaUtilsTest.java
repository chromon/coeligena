package com.coeligena.function.captcha;

import com.coeligena.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <p>
 *     测试验证码生成
 * </p>
 *
 * Created by Ellery on 2017/11/18.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class CaptchaUtilsTest extends UnitTestBase {

    public CaptchaUtilsTest() {
        super("src/main/webapp/WEB-INF/configs/application-context.xml");
    }

    @Test
    public void testGetCaptchaAndImage() {
        CaptchaUtils captcha = super.getBean("captchaUtils");
        captcha.getCaptchaAndImage();
    }
}
