<%--
    header(页眉)的通用界面
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="banner">
    <div class="head"></div>
    <div class="border">
        <div class="style">
            <ul>
                <li class="Group"><a href="${pageContext.request.contextPath}/group/list"><B>团体大厅</B></a></li>
                <li class="Activity"><a href="${pageContext.request.contextPath}/activity/list"><B>活动走廊</B></a></li>
                <li class="Logo"><a href="${pageContext.request.contextPath}/"><B>平台首页</B></a></li>
                <li class="Situation"><a href="${pageContext.request.contextPath}/situation/list"><B>动态展览</B></a></li>
                <li class="Resource"><a href="${pageContext.request.contextPath}/resource/list"><B>资源总库</B></a></li>
            </ul>
        </div>
    </div>
    <c:set var="user" value="${sessionScope.get('user')}"/>
    <c:choose>
        <c:when test="${user != null}">
            <div class="end">
                <div class="user">
                    <div class="user_info">
                        <div class="INFO"></div>
                        <div class="Msg">
                            <div class="NOTICE User_a">
                                <a href="#">通知</a>
                            </div>
                            <div class="NEWS User_a">
                                <a href="#">消息</a>
                            </div>
                        </div>
                    </div>
                    <div class="UserMsg User_a">
                        <a href="#">个人设置</a>
                    </div>
                    <div class="Logout User_a">
                        <a href="javascript:logout.logout();">注销/退出</a>
                    </div>
                </div>
                <div class="HP" style="background:url('${pageContext.request.contextPath}/${user.headPicture}') no-repeat;">
                    <a href="${pageContext.request.contextPath}/personal/msg" title="个人中心"></a>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div id="Login" onclick="login.showLoginDialog();">
                登陆/注册
            </div>
        </c:otherwise>
    </c:choose>
</div>

<!--登录模态框-->
<%@ include file="../dialog/loginAndRegister.jsp"%>
