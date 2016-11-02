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
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
    <link href="${pageContext.request.contextPath}/css/groupMsg.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="background">
    <div class="bg1 "></div>
    <div class="bg2 "></div>
    <div class="bg3 "></div>
    <div class="bg4 "></div>
    <div class="bg5 "></div>
</div>
<div id="container">
    <!-- 页眉 -->
    <div class="banner">
        <div class="head"></div>
        <div class="border">
            <div class="style">
                <ul>
                    <li class="Group"><a href="GroupList.html"><B>团体大厅</B></a></li>
                    <li class="Activity"><a href="ActivityList.html"><B>活动走廊</B></a></li>
                    <li class="Logo"><a href="index.html"><B>平台首页</B></a></li>
                    <li class="Situation"><a href="SituationList.html"><B>动态展览</B></a></li>
                    <li class="Resource"><a href="ResourceList.html"><B>资源总库</B></a></li>
                </ul>
            </div>
        </div>
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
                <div class="LogoOut User_a">
                    <a href="#">注销/退出</a>
                </div>
            </div>
            <div class="HP">
                <a href="#"></a>
            </div>
        </div>
    </div>
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
								<li><a href="index.html">新闻社</a></li>
								<li><a href="index.html">大学生艺术团</a></li>
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
                                <li><a href="index.html"><span class="title">${situation.situationTitle}</span><span class="time">发布时间:&nbsp;<i>${situation.publishTime}</i></span></a></li>
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
                                <li><a href="index.html"><span class="title">${activity.activityTitle}</span><span class="time">发布时间:&nbsp;<i>${activity.publishTime}</i></span></a></li>
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
    <div class="bottom">

        <p>NEUSOFT &nbsp; UNIVERSITY &nbsp;STUDENT &nbsp; GROUP
            &nbsp;PLATFORM</p>

        <P>联系我们 &nbsp; &nbsp;TEL:15382296658 &nbsp; &nbsp;
            EMAIL:shetuan@mail.tsinghua.edu.cn</p>

        <p>ADDRESS: 三期教学楼 A7 307室 &nbsp; &nbsp; WORKING TIME: 周一至周五
            13:00-14:15</p>

    </div>
</div>
<form id="openWin" action="#" target="_blank" method="get"></form>
</body>
</html>

