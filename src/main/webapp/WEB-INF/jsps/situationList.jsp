<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>动态展览</title>
    <%@ include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/situationList.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/dialogCss.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pagination/pagination.css" rel="stylesheet">

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
                <ul id="AllSituation">
                    <c:forEach items="#{situationList}" var="situation">
                        <li><nobr>
                            <a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" target="_blank"><span class='title' title="${situation.situationTitle}">${situation.situationTitle}</span></a><span
                                class='time'>发布时间:&nbsp;<i>${situation.publishTime}</i></span>
                        </nobr></li>
                    </c:forEach>
                </ul>

            </div>

            <%--分页设置--%>
            <div class="wrapper">
                <div class="M-box3"></div>
                <div id="totalPage" hidden>${pagination.totalPage}</div>
                <div id="currentPage" hidden>${pagination.currentPage}</div>
                <div id="showData" hidden>${pagination.showData}</div>
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
                                <a href="${pageContext.request.contextPath}/situation/${newSituation.situationId}/detail" target="_blank"><span class='title' title="${newSituation.situationTitle}">${newSituation.situationTitle}</span></a>
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
                                <a href="${pageContext.request.contextPath}/situation/${hotSituation.situationId}/detail" target="_blank"><span class='title' title="${hotSituation.situationTitle}">${hotSituation.situationTitle}</span></a>
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
<!--加入隐藏背面-->
<div class="hideBack"></div>
<script src="${pageContext.request.contextPath}/js/pagination/jquery.pagination.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pagination/situationPagination.js"></script>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>
</body>
</html>

