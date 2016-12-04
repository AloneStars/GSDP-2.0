package com.gsdp.interceptor;

import com.gsdp.entity.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/28 创造的作品
 * ********************************************************
 * +描述:验证用户登录拦截器
 *********************************************************/
public class CheckLoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {

        HttpSession session = Request.getSession();
        User user = (User)session.getAttribute("user");


        if(user == null){
            System.out.println("验证登录失败");
            return false;
        }
        else{
            System.out.println("验证登录成功");
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
