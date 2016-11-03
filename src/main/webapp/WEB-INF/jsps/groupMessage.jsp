<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>团队信息</title>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="/GSDP/css/groupMsg.css" type="text/css" rel="stylesheet">
    <link href="/GSDP/css/common.css" type="text/css" rel="stylesheet">
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
    <%@ include file="common/header.jsp"%>
    <!-- 内容版块 -->
    <div id="content-container">
        <!-- banner版块 -->
        <div id="banner">

            <!-- 左部 -->
            <div id="banner-left" class="shadow">
                <div id="banner-left-top">
                    <img id="groupIcon" src="" />
                </div>

                <div id="banner-left-bottom">
                    <div class="groupName">
                        <span><b id="groupName"></b></span>
                    </div>
                    <div class="Intro">
                        成员人数：<span id="member_num">100</span>
                    </div>
                    <div class="Intro">
                        联系方式：<span id="groupContact"></span>
                    </div>
                    <div class="Intro">
                        办公地点：<span id="groupAddress"></span>
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
							<p id="groupDec"></p>
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
                            <!-- <li><a href="index.html"><span class="title"></span><span class="time">发布时间:&nbsp;<i></i></span></a></li> -->
                        </ul>
                    </div>
                </div>

                <div id="content-right-center" class="NAF">
                    <div class="content-right-title">
                        <span><b><i>最新活动</i></b></span>
                    </div>
                    <div class="content-right-list">
                        <ul class="content-list" id="AL">
                        </ul>
                    </div>
                </div>

                <div id="content-right-bottom" class="NAF">
                    <div class="content-right-title">
                        <span><b><i>最新资源</i></b></span>
                    </div>
                    <div class="content-right-list">
                        <ul class="content-list" id="RL">
                        </ul>
                    </div>
                </div>

            </div>

        </div>


    </div>
    <!-- 页脚 -->
    <%@ include file="common/footer.jsp"%>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="/GSDP/js/common.js"></script>
    <script src="/GSDP/js/groupMsg.js"></script>
</div>
</body>
</html>
