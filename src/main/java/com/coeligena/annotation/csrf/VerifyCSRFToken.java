package com.coeligena.annotation.csrf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 跨站请求伪造注解 验证跨站请求
 * </p>
 *
 * Created by Ellery on 2017/12/2.
 */
@Target({ java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyCSRFToken {

    /**
     * 需要验证防跨站请求
     * @return
     */
    public abstract boolean verify() default true;

}