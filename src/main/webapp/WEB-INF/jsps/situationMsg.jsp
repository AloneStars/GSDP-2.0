<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/13
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<html>
<head>
    <title>动态详情</title>
    <%@  include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/situationMsg.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
    <!-- 页眉 -->
    <jsp:include page="common/header.jsp"/>
    <!-- 内容版块 -->
    <div id="content-container">

        <div class="left">
            <%--更多动态--%>
            <div class="more-situation shadow">
                <div class="situationMsg-banner">
                    <b><i>更多动态</i></b>
                </div>
                <div class="situation-list">
                    <ul>
                        <c:forEach items="#{moreSituationList}" var="moreSituation">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/situation/${moreSituation.situationId}/detail" target="_blank"><span class='title' title="${moreSituation.situationTitle}">${moreSituation.situationTitle}</span></a>
                            </nobr></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <div class="right shadow">
            <%--动态详情--%>
            <div class="situation-content">
                <div class="situationMsg-banner">
                    <b><i>动态详情</i></b>
                </div>
                <div class="situation-detail">
                     <center><h4>${situation.situationTitle}</h4></center>
                     ${situation.situationContent}
                </div>
            </div>
            <%--评论区--%>
            <div class="comments">
                <div class="situationMsg-banner">
                    <b><i>评论区</i></b>
                </div>
                <div class="comment-list">
                    <ul>
                        <c:forEach items="#{situation.notices}" var="reply">
                            <li>
                                <img src="${pageContext.request.contextPath}/image/groupIcon/${reply.user.headPicture}"/>
                                <div class="comments-msg">
                                    <div class="commenter"><span><i>${reply.user.username}</i></span><span ><i>发布时间:${reply.replyTime}</i></span></div>
                                    <p>${reply.replyContent}</p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>

                </div>
                <div class="comment">
                    <form action="" method="post">
                        <input class="message" type="text"/>
                        <input class="submit" type="submit" value="发表"/>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
