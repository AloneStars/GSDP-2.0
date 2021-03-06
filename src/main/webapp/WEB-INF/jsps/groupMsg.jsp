<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>团队详情</title>
    <%@include file="common/style.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pathMenu/pathMenu.js"></script>
    <link href="${pageContext.request.contextPath}/css/groupMsg.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pathMenu/pathMenu.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/dialogCss.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pagination/pagination.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
    <!-- 页眉 -->
    <jsp:include page="common/header.jsp"/>
    <jsp:include page="common/rotateMenu.jsp"/>
    <!-- 内容版块 -->
    <div id="content-container">
        <!-- banner版块 -->
        <div id="banner">

            <!-- 左部 -->
            <div id="banner-left" class="shadow">

                <%--这里埋了一个hidden，好获取团队的id--%>
                <div id="groupId" hidden>${group.groupId}</div>

                <div id="banner-left-top">
                    <img id="groupIcon" src="${pageContext.request.contextPath}/${group.groupIcon}" />
                </div>

                <div id="banner-left-bottom">

                    <div class="groupName">
                        <span><b id="groupName">${group.groupName}</b></span>
                    </div>
                    <div class="Intro">
                        成员人数：<span id="member_num">${group.groupMembers}</span>
                    </div>
                    <div class="Intro">
                        联系方式：<span id="groupContact">${group.groupContact}</span>
                    </div>
                    <div class="Intro">
                        办公地点：<span id="groupAddress">${group.groupAddress}</span>
                    </div>

                    <c:set var="groupId" value="${group.groupId}"/>
                    <c:forEach items="${sessionScope.get('identities')}" var="map">
                        <c:if test="${map.key == groupId}">
                            <c:set var="identity" value="${map.value}"/>
                        </c:if>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${sessionScope.get('user') != null}">
                            <c:choose>
                                <c:when test="${identity == 'owner'}">
                                    <div class="Intro">
                                        <input type="button" value="退出组织" onclick="alert('法人不能轻易退出组织,请慎重...');">
                                    </div>
                                </c:when>
                                <c:when test="${identity == 'member' or identity == 'admin'}">
                                    <div class="Intro">
                                        <input type="button" value="退出组织" onclick="if(confirm('你确定要退出组织吗?')){group.quitGroup();}">
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="Intro">
                                        <input type="button" value="申请加入" onclick="group.showJoinGroupDialog();">
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <div class="Intro">
                                <input type="button" value="申请加入" onclick="alert('请先进行登录操作');">
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>

            <!-- 右部 -->
            <div id="banner-right" class="shadow">

                <div id="myCarousel" class="carousel slide">
                    <!-- 轮播（Carousel）指标 -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/image/slide1.jpg" alt="First slide">
                            <div class="carousel-caption">
                                <p>Android系统是最屌的</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/image/slide2.png" alt="Second slide">
                            <div class="carousel-caption">
                                <p>iOS还活着，永远轮不到android</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/image/slide3.png" alt="Third slide">
                            <div class="carousel-caption">
                                <p>HTC的品牌也不错好吗</p>
                            </div>
                        </div>
                    </div>
                    <!-- 轮播（Carousel）导航 -->
                    <a class="carousel-control left" href="#myCarousel"
                       data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
                                                         href="#myCarousel" data-slide="next">&rsaquo;</a>
                </div>

            </div>

        </div>
        <!--内容-->
        <div id="content">

            <!--内容左部-->
            <div id="content-left">

                <div id="content-left-top" class="shadow">
						<span> <b class="content-title"><i>关于我们:</i></b><br>
							<p id="groupDec">${group.groupDec}</p>
						</span>
                </div>

                <div id="content-left-bottom" class="shadow">
						<span> <b class="content-title"><i>更多团体:</i></b><br>
							<ul class="content-list">
                                <c:forEach items="#{groupList}" var="group">
                                    <li><a href="${pageContext.request.contextPath}/group/${group.groupId}/detail" <%--target="_blank"--%>>${group.groupName}</a></li>
                                </c:forEach>
							</ul>
						</span>
                </div>

            </div>
            <!--内容右部-->
            <div id="content-right" class="shadow">
                <div id="content-right-top" class="NAF">
                    <div class="content-right-title">
                        <span><b><i>最新动态</i></b></span>
                    </div>
                    <div class="content-right-list">
                        <ul class="content-list" id="SL">
                            <c:forEach items="#{situationList}" var="situation">
                                <li><a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" target="_blank"><span class="title">${situation.situationTitle}</span><span class="time">发布时间:&nbsp;<i>${situation.publishTime}</i></span></a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div id="content-right-center" class="NAF">
                    <div class="content-right-title">
                        <span><b><i>最新活动</i></b></span>
                    </div>
                    <div class="content-right-list">
                        <ul class="content-list" id="AL">
                            <c:forEach items="#{activityList}" var="activity">
                                <li><a href="${pageContext.request.contextPath}/activity/${activity.activityId}/detail"><span class="title">${activity.activityTitle}</span><span class="time">发布时间:&nbsp;<i>${activity.publishTime}</i></span></a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div id="content-right-bottom" class="NAF">
                    <div class="content-right-title">
                        <span><b><i>最新资源</i></b></span>
                    </div>
                    <div class="content-right-list">
                        <ul class="content-list" id="RL">
                            <%--<c:forEach items="" var="">
                                <li><a href="index.html"><span class="title"></span><span class="time">发布时间:&nbsp;<i></i></span></a></li>
                            </c:forEach>--%>
                        </ul>
                    </div>
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
<script src="${pageContext.request.contextPath}/common/datepicker/laydate.dev.js"></script>
<!-- 配置文件 -->
<script src="${pageContext.request.contextPath}/common/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="${pageContext.request.contextPath}/common/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script src="${pageContext.request.contextPath}/common/ueditor/lang/zh-cn/zh-cn.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/upload/ajaxfileupload.js"></script>
<script src="${pageContext.request.contextPath}/js/request/activity.js"></script>
<script src="${pageContext.request.contextPath}/js/request/group.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>
<script src="${pageContext.request.contextPath}/js/request/situation.js"></script>
<script src="${pageContext.request.contextPath}/js/request/notice.js"></script>
</body>
</html>


