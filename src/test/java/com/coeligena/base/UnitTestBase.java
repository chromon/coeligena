package com.coeligena.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 单元测试基类，完成对 spring 配置文件的加载、销毁
 *
 * Created by Ellery on 2017/9/12.
 */
public class UnitTestBase {

    private FileSystemXmlApplicationContext context;

    private String springConfigPath;

    public UnitTestBase() {}

    public UnitTestBase(String springXmlPath) {
        this.springConfigPath = springXmlPath;
    }

    @Before
    public void before() {
        // 判断 spring 配置文件路径
        if (StringUtils.isEmpty(springConfigPath)) {
            springConfigPath = "src/main/webapp/WEB-INF/configs/*-context.xml";
        }
        try {
            // 加载配置文件，创建文件上下文
            context = new FileSystemXmlApplicationContext(springConfigPath);
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.destroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        try {
            return (T) context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

}

