<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/1
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>团队详情</title>
    <%@include file="common/style.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pathMenu.js"></script>
    <link href="${pageContext.request.contextPath}/css/groupMsg.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pathMenu.css" type="text/css" rel="stylesheet" />
    <jsp:include page="dialog/dialogCss.jsp"/>
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
                    <div class="Intro">
                        <input type="button" value="申请加入">
                    </div>

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
                            <img src="image/slide1.jpg" alt="First slide">
                            <div class="carousel-caption">
                                <p>Android系统是最屌的</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="image/slide2.png" alt="Second slide">
                            <div class="carousel-caption">
                                <p>iOS还活着，永远轮不到android</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="image/slide3.png" alt="Third slide">
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
                                    <li><a href="${pageContext.request.contextPath}/group/${group.groupId}/detail" target="_blank">${group.groupName}</a></li>
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
<script src="${pageContext.request.contextPath}/js/request/activity.js"></script>
<jsp:include page="dialog/dialogJs.jsp"/>
<jsp:include page="dialog/ueditorJs.jsp"/>
</body>
</html>


