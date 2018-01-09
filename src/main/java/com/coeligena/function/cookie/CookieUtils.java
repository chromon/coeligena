package com.coeligena.function.cookie;

import com.coeligena.function.security.Encrypt;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <P>
 *     Cookie 工具类
 * </P>
 *
 * Created by Ellery on 2017/12/19.
 */
@Component
public class CookieUtils {

    /**
     * 设置 cookie
     * @param response HttpServletResponse
     * @param name cookie 名称
     * @param value cookie 值
     * @param maxAge cookie 生命周期（秒）
     */
    public void addCookie(HttpServletResponse response,
                                 String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        if(maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 将 cookies 数组封装到 map
     * @param request HttpServletRequest
     * @return 封装的 map
     */
    private Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(null != cookies) {
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 根据名字获取 cookie
     * @param request HttpServletRequest
     * @param name cookie 名字
     * @return cookie
     */
    public Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = this.readCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 删除 cookie
     * @param key cookie key
     */
    public void removeCookie(HttpServletResponse response, String key) {
        Cookie cookie = new Cookie(key, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public String getEncryptName(String cookieName) {
        return Encrypt.getDigest("MD5", cookieName);
    }

    public String getEncryptValue(String cookieValue) {
        return Encrypt.getDigest("SHA", cookieValue);
    }
}
