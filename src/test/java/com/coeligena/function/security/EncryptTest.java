package com.coeligena.function.captcha.security;

import com.coeligena.base.UnitTestBase;
import com.coeligena.function.security.Encrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 密码加密单元
 *
 * <p>
 * Created by Ellery on 2017/9/15.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class EncryptTest extends UnitTestBase {

    public EncryptTest() {
        super("src/main/webapp/WEB-INF/configs/application-context.xml");
    }

    @Test
    public void testGetDigest() {
        Encrypt e = super.getBean("encrypt");
        System.out.println(e.getDigest("SHA-256", "hello world"));
        System.out.println(e.getDigest("SHA-512", "hello world"));
    }
}
