package com.gsdp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截所有没有登录的用户访问一些url
 * Created by yizijun on 2016/11/26 0026.
 */
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        if(null != session) {
            if(null != session.getAttribute("user")) {
                return true;
            }
        }

        System.out.println("状态码" + response.getStatus());

        //跳到错误处理页面
        request.setAttribute("errMessage","你还未登录，请先登录");
        request.getRequestDispatcher("/authorityError").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
