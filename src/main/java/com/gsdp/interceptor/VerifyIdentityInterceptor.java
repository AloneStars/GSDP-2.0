package com.gsdp.interceptor;

import com.gsdp.entity.group.Group;
import com.gsdp.entity.user.User;
import com.gsdp.exception.user.VerifyAdminException;
import com.gsdp.exception.user.VerifyMemberException;
import com.gsdp.service.GroupService;
import com.gsdp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/11/24 创造的作品
 * ********************************************************
 * +描述:身份验证拦截器
 *********************************************************/
public class VerifyIdentityInterceptor implements HandlerInterceptor{

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        HttpSession session = request.getSession();

        Map<Integer,String> identities = (Map<Integer,String>)session.getAttribute("identities");

        if(identities == null)
            identities = new HashMap<Integer,String>();

        User user = (User) session.getAttribute("user");

        int groupId = Integer.parseInt(request.getRequestURI().split("/")[3]);

        Group group = groupService.getGroupMsg(groupId);

        if(user != null) {

            int userId = user.getUserId();

            try {
                if (group.getOwner() == userId) {
                    identities.put(groupId, "owner");
                   // session.setAttribute(Integer.toString(groupId), "owner");
                    System.out.println("法人身份验证成功");
                }else if (userService.verifyMember(userId, groupId)) {
                    identities.put(groupId, "member");
                    //session.setAttribute(Integer.toString(groupId), "member");
                    System.out.println("成员身份验证成功");
                    if (userService.verifyAdmin(userId, groupId)) {
                        identities.put(groupId, "admin");
                       // session.setAttribute(Integer.toString(groupId), "admin");
                        System.out.println("管理员身份验证成功");
                    }
                } else {
                    identities.put(groupId, "visitor");
                   // session.setAttribute(Integer.toString(groupId), "visitor");
                    System.out.println("游客验证成功");
                }
            } catch (VerifyAdminException e) {
                System.out.println("管理员身份验证失败");
            } catch (VerifyMemberException e) {
                identities.put(groupId, "visitor");
                System.out.println("成员身份验证失败");
            }
        }

        session.setAttribute("identities",identities);

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
