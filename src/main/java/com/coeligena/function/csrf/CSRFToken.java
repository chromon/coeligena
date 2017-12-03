package com.coeligena.function.csrf;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * <p>
 *     生成 CSRFToken
 * </p>
 *
 * Created by Ellery on 2017/12/2.
 */
public class CSRFToken {

    public static String generate(HttpServletRequest request) {
        return UUID.randomUUID().toString();
    }
}
