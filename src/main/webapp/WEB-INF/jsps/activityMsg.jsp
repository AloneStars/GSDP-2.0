<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<head>
    <title>活动详情</title>
    <%@include file="common/style.jsp" %>
    <link href="${pageContext.request.contextPath}/css/activityMsg.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dialogCss.css" rel="stylesheet">
</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
    <!-- 页眉 -->
    <jsp:include page="common/header.jsp"/>
    <!-- 内容版块 -->
    <div id="content-container">

        <div class="left">
            <%--更多活动--%>
            <div class="more-activity shadow">
                <div class="activityMsg_banner">
                    <b><i>更多活动</i></b>
                </div>
                <div class="activityList">
                    <ul>
                        <c:forEach items="${moreActivityList}" var="moreActivity">
                            <li><nobr>
                                <a href="${pageContext.request.contextPath}/activity/${moreActivity.activityId}/detail" target="_blank"><span class='title' title="${moreActivity.activityTitle}">${moreActivity.activityTitle}</span></a>
                            </nobr></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <div class="right shadow">
            <%--基本信息--%>
            <div class="base-info">
                <div class="activityMsg_banner">
                    <b><i>基本信息</i></b>
                </div>
                <div class="base-msg-container">


                   <div class="activity-icon">
                        <img src="${pageContext.request.contextPath}/${group.groupIcon}"/>
                        <div class="sponsor"><b><i><p>主办方:${group.groupName}</p></i></b></div>
                    </div>
                    <%--活动详情信息--%>
                    <div class="activity-msg">
                        <h4><b>${activity.activityTitle}</b></h4>
                        <p><b>活动时间:</b> <i>${activity.beginTime} — ${activity.endTime}</i></p>
                        <p><b>发起时间:</b> <i>${activity.publishTime}</i></p>
                        <p><b>活动地点:</b> <i>${activity.activityAddress}</i></p>
                        <p><b>活动人数:</b> <i>${activity.activityNumber}</i></p>
                    </div>

                </div>
            </div>
            <%--活动详情--%>
            <div class="activity-content">
                <div class="activityMsg_banner">
                    <b><i>活动详情</i></b>
                </div>
                <div class="activity-detail">
                    ${activity.activityContent}
                </div>
            </div>
        </div>

    </div>
    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>
</div>
<!--加入隐藏背面-->
<div class="hideBack"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>
</body>
</html>
