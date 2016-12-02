package com.gsdp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CheckAdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		int groupId = Integer.parseInt(request.getParameter("groupId"));

		Map<Integer,String> identities = null;

		String identity = null;

		if(session.getAttribute("identities") != null){
			identities = (Map<Integer,String>)session.getAttribute("identities");
			identity = identities.get(groupId);
		}

		if("admin".equals(identity)||"owner".equals(identity)){
			System.out.println("验证管理成功");
			return true;
		}
		else {
			System.out.println("验证管理失败");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}


}
