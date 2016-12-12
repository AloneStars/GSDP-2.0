<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <title>动态详情</title>
    <%@  include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/situationMsg.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/dialogCss.css" rel="stylesheet">
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
                        <c:forEach items="${moreSituationList}" var="moreSituation">
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
                <div id="situationId" hidden>${situation.situationId}</div>
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
                        <c:forEach items="${situation.notices}" var="reply">
                            <li>
                                <c:choose>
                                    <c:when test="${sessionScope.get('user') != null}">
                                        <a href="${pageContext.request.contextPath}/personal/${reply.user.userId}/detail"><img src="${pageContext.request.contextPath}/${reply.user.headPicture}"/></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:alert('请先进行登陆操作...');"><img src="${pageContext.request.contextPath}/${reply.user.headPicture}"/></a>
                                    </c:otherwise>
                                </c:choose>

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
                        <c:choose>
                            <c:when test="${sessionScope.get('user') != null}">
                                <input id="replyMessage" class="message" type="text" placeholder="你想说点啥呢...(200字以内效果最佳)" autocomplete="off"/>
                                <input id="reply" class="submit" type="button" value="发表" />
                            </c:when>
                            <c:otherwise>
                                <input id="replyMessage" class="message" type="text" placeholder="你想说点啥呢...(200字以内效果最佳)" autocomplete="off" onclick="alert('请先进行登陆操作...');"/>
                                <input id="reply" class="submit" type="button" value="发表" disabled/>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>
</div>
<!--加入隐藏背面-->
<div class="hideBack"></div>

<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>
<script src="${pageContext.request.contextPath}/js/request/reply.js"></script>
</body>
</html>
