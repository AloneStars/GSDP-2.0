<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>活动走廊</title>
    <%@ include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/activityList.css" type="text/css" rel="stylesheet">
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
            <div class="activity_banner">
                <b><i>活动走廊</i></b>
            </div>
            <div class="left_content">
                <ul id="AllActivity">
                    <c:forEach items="${activityList}" var="activity">
                        <li>
                            <a href="${pageContext.request.contextPath}/activity/${activity.activityId}/detail" target="_blank"><span class='title'>${activity.activityTitle}</span></a>
                            <span class='time'>发布时间:&nbsp;<i>${activity.publishTime}</i></span>
                        </li>
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
                <div class="activity_banner">
                    <b><i>最新活动</i></b>
                </div>
                <div class="right_top_content">
                    <ul>
                        <c:forEach items="${newestActivityList}" var="newActivity">
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
                        <c:forEach items="${hottestActivityList}" var="hotActivity">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/activity/${hotActivity.activityId}/detail"><span class='title' title="${hotActivity.activityTitle}">${hotActivity.activityTitle}</span></a>
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
<script src="${pageContext.request.contextPath}/js/pagination/activityPagination.js"></script></body>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>

</html>

