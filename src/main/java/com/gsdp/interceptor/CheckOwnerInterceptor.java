package com.gsdp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 这是一个拦截器的样例，我们可以通过拦截器来完成字符编码，用户角色的控制等工作。
 * @author yizijun
 */
public class CheckOwnerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		Integer groupId = Integer.parseInt(request.getParameter("groupId"));

		Map<Integer,String> identities = null;

		String identity = null;

		if(session.getAttribute("identities") != null){
			identities = (Map<Integer,String>)session.getAttribute("identities");
			identity = identities.get(groupId);
		}

		System.out.println(identity);

		if("owner".equals(identity))
			return true;
		else
			return false;

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
