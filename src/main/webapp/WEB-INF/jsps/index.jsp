<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/10
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>平台首页</title>
    <%@ include file="common/style.jsp"%>
    <script src="js/index.js"></script>
    <link href="css/animations.css" type="text/css" rel="stylesheet">
    <link href="css/index.css" type="text/css" rel="stylesheet">
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
        <div id="main_lobby">
            <div class="top">

                <div class="top_left shadow">
                    <div class="index_banner">
                        <b><i>滚动新闻</i></b>
                    </div>
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

                <div class="top_right">
                    <%--优秀社团--%>
                    <div class="top_right_top shadow">
                        <div class="index_banner">
                            <b><i>优秀社团</i></b>
                        </div>
                        <div class="Best_group">
                            <div class="groupIcon"></div>
                            <div class="groupDec">
                                <div class="name">
                                    <span><b><i>星空摄影团队</i></b></span>
                                </div>
                                <div class="time">
                                    <span><nbor> <i>评选年度：2016年</i></nbor></span>
                                </div>
                                <div class="dec">
                                    <nbor> <span><i>简介：我们是黑夜的探索者，时刻的守候在寂静的夜空中，只为留下那一瞬的惊艳，用不一样的眼，发现不一样的世界，这就是我们
												—— 星空摄影协会。</i></span></nbor>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--优秀人物--%>
                    <div class="top_right_bottom shadow">
                        <div class="index_banner">
                            <b><i>优秀人物</i></b>
                        </div>
                        <div class="Best_member">
                            <div class="top_container">
                                <div class="userIcon"></div>
                                <div class="userDec">
                                    <div class="name">
                                        <span><b><i>李明轩</i></b></span>
                                    </div>
                                    <div class="belong">
                                        <span><i>所属团队：星空摄影团队</i></span>
                                    </div>
                                    <div class="time">
                                        <span><nbor> <i>评选年度：2016年</i></nbor></span>
                                    </div>
                                    <div class="time">
                                        <span><nbor> <i>评选原因：热情，乐观，有责任心，乐于助人。在学生中很受欢迎。</i></nbor></span>
                                    </div>
                                </div>
                            </div>
                            <div class="bottom_container">
                                <div class="achievement">
                                    <span><i>个人成就：2016年大连东软信息学院亿达奖学金一等奖</i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


            <div class="center">

                <div class="center_top">

                    <%--最新活动--%>
                    <div class="center_top_left shadow">
                        <div class="index_banner">
                            <b><i>最热活动</i></b>
                        </div>
                        <div class="activityList">
                            <div class="List gap" style="border-right: 1px dashed #fff">
                                <ul>
                                    <c:forEach items="#{activityList}" var="activity" begin="0" end="9">
                                        <li><nobr>
                                            <a href="${pageContext.request.contextPath}/activity/${activity.activityId}/detail" target="_blank"><span class='title'
                                                              title="${activity.activityTitle}">${activity.activityTitle}</span></a>
                                        </nobr></li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="List gap">
                                <ul start="11">
                                    <c:forEach items="#{activityList}" var="activity" begin="10" end="19">
                                        <li><nobr>
                                            <a href="${pageContext.request.contextPath}/activity/${activity.activityId}/detail" target="_blank"><span class='title'
                                                              title="${activity.activityTitle}">${activity.activityTitle}</span></a>
                                        </nobr></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <%--最新动态--%>
                    <div class="center_top_right shadow">
                        <div class="index_banner">
                            <b><i>最新动态</i></b>
                        </div>
                        <div class="situationList">
                            <ul>
                                <c:forEach items="#{situationList}" var="situation">
                                    <li><nobr>
                                        <a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" target="_blank"><span class='title'
                                                          title="${situation.situationTitle}">${situation.situationTitle}</span></a>
                                    </nobr></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>

                <div class="center_bottom">

                    <%--每周最佳活动--%>
                    <div class="center_bottom_left shadow">
                        <div class="index_banner">
                            <b><i>每周最佳活动</i></b>
                        </div>
                        <a href="#">
                            <div class="img">
                                <div class="alt">最佳活动描述...</div>
                            </div>
                        </a>
                    </div>

                    <%--社团品牌活动--%>
                    <div class="center_bottom_center shadow">
                        <div class="index_banner">
                            <b><i>社团品牌活动</i></b>
                        </div>
                        <a href="#">
                            <div class="img">
                                <div class="alt">品牌活动描述...</div>
                            </div>
                        </a>
                    </div>

                    <%--团队映像展览--%>
                    <div class="center_bottom_right shadow">
                        <div class="index_banner">
                            <b><i>团体映像</i></b>
                        </div>
                        <a href="#">
                            <div class="img">
                                <div class="alt">团体映像活动描述...</div>
                            </div>
                        </a>
                    </div>

                </div>

            </div>

            <%--常用链接--%>
            <div class="under shadow"></div>

        </div>

    </div>
    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>

</div>

<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
</body>
</html>

