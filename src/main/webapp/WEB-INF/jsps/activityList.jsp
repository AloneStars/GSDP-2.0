<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/3
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>活动走廊</title>
    <%@ include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/activityList.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
    <!-- 页眉 -->
    <jsp:include page="common/header.jsp"/>
    <!-- 内容版块 -->
    <div id="content-container">
        <div class="left shadow">
            <div class="activity_banner">
                <b><i>活动走廊</i></b>
            </div>
            <div class="left_content">
                <ul id="AllActivity">
                    <c:forEach items="#{activityList}" var="activity">
                        <li>
                            <a href="${pageContext.request.contextPath}/activity/${activity.activityId}/detail" target="_blank"><span class='title'>${activity.activityTitle}</span></a>
                            <span class='time'>发布时间:&nbsp;<i>${activity.publishTime}</i></span>
                        </li>
                    </c:forEach>
                </ul>
            </div>


        </div>

        <div class="right">

            <div class="right_top shadow">
                <div class="activity_banner">
                    <b><i>最新活动</i></b>
                </div>
                <div class="right_top_content">
                    <ul>
                        <c:forEach items="#{newestActivityList}" var="newActivity">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/activity/${newActivity.activityId}/detail"><span class='title' title="${newActivity.activityTitle}">${newActivity.activityTitle}</span></a>
                            </nobr></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="right_bottom shadow">
                <div class="activity_banner">
                    <b><i>最热活动</i></b>
                </div>
                <div class="right_bottom_content">
                    <ul>
                        <C:forEach items="#{hottestActivityList}" var="hotActivity">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/activity/${hotActivity.activityId}/detail"><span class='title' title="${hotActivity.activityTitle}">${hotActivity.activityTitle}</span></a>
                            </nobr></li>
                        </C:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>

