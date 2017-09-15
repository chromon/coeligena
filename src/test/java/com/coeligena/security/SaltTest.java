package com.coeligena.security;

import com.coeligena.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 密码加密盐单元测试
 *
 * Created by Ellery on 2017/9/12.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SaltTest extends UnitTestBase {

    public SaltTest() {
        super("src/main/webapp/WEB-INF/configs/application-context.xml");
    }

    @Test
    public void testGetSalt() {
        Salt salt = super.getBean("salt");
        System.out.println(salt.getSalt());
    }
}
