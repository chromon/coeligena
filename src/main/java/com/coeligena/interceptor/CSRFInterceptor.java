package com.coeligena.interceptor;

import com.coeligena.annotation.csrf.RefreshCSRFToken;
import com.coeligena.annotation.csrf.VerifyCSRFToken;
import com.coeligena.function.csrf.CSRFToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * CSRFInterceptor 防止跨站请求伪造拦截器
 *
 * Created by Ellery on 2017/12/2.
 */
public class CSRFInterceptor extends HandlerInterceptorAdapter {

    // jackson mapper
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器；
     * @param request 请求
     * @param response 响应
     * @param handler 响应处理器
     * @return true表示继续流程（如调用下一个拦截器或处理器）；
     *         false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，
     *         此时需要通过response来产生响应；
     * @throws Exception 抛出异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 提交表单 token 校验
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        VerifyCSRFToken verifyCSRFTokenAnnotation = method.getAnnotation(VerifyCSRFToken.class);

        // 如果配置了校验 csrf token 校验
        if (verifyCSRFTokenAnnotation != null) {

            // 判断是否为Ajax标志
            // Ajax请求(异步)和传统(get post)请求(同步)，在请求的 Header 不同
            // Ajax 异步请求比传统的同步请求多了一个头参数(X-Requested-With)
            // 为 null，则为传统同步请求，为 XMLHttpRequest，则为 Ajax 异步请求。
            String xmlHttpRequest = request.getHeader("X-Requested-With");

            // 非法的跨站请求校验
            if (verifyCSRFTokenAnnotation.verify() && !checkCSRFToken(request)) {
                if (StringUtils.isEmpty(xmlHttpRequest)) {

                    // 传统同步请求方式，刷新 csrfToken 并跳转提示页面
                    String csrfToken = CSRFToken.generate(request);
                    request.getSession().setAttribute("CSRFToken", csrfToken);
                    // response.setContentType("application/json;charset=UTF-8");
                    // PrintWriter out = response.getWriter();
                    // out.print("非法请求");
                    // response.flushBuffer();
                    response.sendRedirect(request.getContextPath() + "/illegalrequest");
                    return false;
                } else {

                    // Ajax 异步请求，刷新 CSRFToken，返回错误码，用于 ajax 处理，可自定义
                    String csrfToken = CSRFToken.generate(request);
                    request.getSession().setAttribute("CSRFToken", csrfToken);
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.print(mapper.writeValueAsString("CSRF ERROR:无效的 token，或者 token 过期"));
                    response.flushBuffer();
                    return false;
                }
            }

        }
        return true;
    }

    /*
        postHandle：。
     */

    /**
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时可以通过 modelAndView
     * 对模型数据进行处理或对视图进行处理
     * @param request 请求
     * @param response 响应
     * @param handler 响应处理器
     * @param modelAndView 对模型数据进行处理或对视图进行处理，modelAndView 也可能为 null
     * @throws Exception 抛出异常
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 第一次生成 token
        if (modelAndView != null) {
            if (request.getSession(false) == null ||
                    StringUtils.isEmpty(request.getSession(false).getAttribute("CSRFToken"))) {

                request.getSession().setAttribute("CSRFToken", CSRFToken.generate(request));
                return;
            }
        }

        // 刷新 token
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        RefreshCSRFToken refreshAnnotation = method.getAnnotation(RefreshCSRFToken.class);

        // 跳转到一个新页面 刷新 token
        String xmlHttpRequest = request.getHeader("X-Requested-With");
        if (refreshAnnotation != null && refreshAnnotation.refresh() &&
                StringUtils.isEmpty(xmlHttpRequest)) {

            request.getSession().setAttribute("CSRFToken", CSRFToken.generate(request));
            return;
        }

        // 校验成功 刷新 token 可以防止重复提交
        VerifyCSRFToken verifyAnnotation = method.getAnnotation(VerifyCSRFToken.class);
        if (verifyAnnotation != null) {
            if (verifyAnnotation.verify()) {
                if (StringUtils.isEmpty(xmlHttpRequest)) {
                    request.getSession().setAttribute("CSRFToken", CSRFToken.generate(request));
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("CSRFToken", CSRFToken.generate(request));
                    response.setContentType("application/json;charset=UTF-8");
                    OutputStream out = response.getOutputStream();
                    out.write((",'csrf':" + mapper.writeValueAsString(map) + "}").getBytes("UTF-8"));
                }
            }
        }
    }

    /**
     * 处理跨站请求伪造 针对需要登录后才能处理的请求,验证CSRFToken校验
     *
     * @param request HttpServletRequest
     */
    private boolean checkCSRFToken(HttpServletRequest request) {

        // 请求参数中的 CSRFToken
        String requestParamCSRFToken = request.getParameter("CSRFToken");
        // XMLHttpRequest 设置的 header 中的 CSRFToken
        String requestHeaderCSRFToken = request.getHeader("CSRFToken");

        String requestCSRFToken;

        if (StringUtils.isEmpty(requestHeaderCSRFToken)) {
            if (StringUtils.isEmpty(requestParamCSRFToken)) {
                // form 表单参数以及 ajax header 均为空
                return false;
            } else {
                // form 表单不为空
                requestCSRFToken = requestParamCSRFToken;
            }
        } else {
            // ajax header 不为空
            requestCSRFToken = requestHeaderCSRFToken;
        }

        // session CSRFToken
        String sessionCSRFToken = (String) request.getSession().getAttribute("CSRFToken");
        if (StringUtils.isEmpty(sessionCSRFToken)) {
            return false;
        }

        return requestCSRFToken.equals(sessionCSRFToken);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
