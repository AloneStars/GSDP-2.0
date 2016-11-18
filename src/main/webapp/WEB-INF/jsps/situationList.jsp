<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/6
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>动态展览</title>
    <%@ include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/situationList.css" type="text/css" rel="stylesheet">

</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
    <!-- 页眉 -->
    <jsp:include page="common/header.jsp"/>
    <!-- 内容版块 -->
    <div id="content-container">
        <div class="left shadow">
            <div class="situation_banner">
                <b><i>动态展览</i></b>
            </div>
            <div class="left_content">
                <ul>
                    <c:forEach items="#{situationList}" var="situation">
                        <li><nobr>
                            <a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" target="_blank"><span class='title' title="${situation.situationTitle}">${situation.situationTitle}</span></a><span
                                class='time'>发布时间:&nbsp;<i>${situation.publishTime}</i></span>
                        </nobr></li>
                    </c:forEach>
                </ul>
            </div>


        </div>

        <div class="right">

            <div class="right_top shadow">
                <div class="situation_banner">
                    <b><i>最新动态</i></b>
                </div>
                <div class="right_top_content">
                    <ul>
                        <c:forEach items="#{newestSituationList}" var="newSituation">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" target="_blank"><span class='title' title="${newSituation.situationTitle}">${newSituation.situationTitle}</span></a>
                            </nobr></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="right_bottom shadow">
                <div class="situation_banner">
                    <b><i>最热动态</i></b>
                </div>
                <div class="right_bottom_content">
                    <ul>
                        <c:forEach items="#{hottestSituationList}" var="hotSituation">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" target="_blank"><span class='title' title="${hotSituation.situationTitle}">${hotSituation.situationTitle}</span></a>
                            </nobr></li>
                        </c:forEach>
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

