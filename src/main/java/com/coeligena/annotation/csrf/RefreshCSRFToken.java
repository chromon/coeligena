package com.coeligena.annotation.csrf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 跨站请求伪造注解 刷新 CSRFToken
 * </p>
 *
 * Created by Ellery on 2017/12/2.
 */
@Target({ java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RefreshCSRFToken {

    /**
     * 刷新 token
     * @return 是否刷新成功
     */
    public abstract boolean refresh() default true;
}
