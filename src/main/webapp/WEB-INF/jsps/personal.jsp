<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/12/1
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人中心</title>
    <%@ include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/animations.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/personal.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/timeLine/timeline.css" rel="stylesheet" />
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

        <div id="personal_lobby">
            <div id="personal_container">

                <div id="personal_container_top">

                    <div id="personal_msg" class="shadow">

                        <div class="personal_banner" style="margin-top:0px;">
                            <b><i>个人信息</i></b>
                        </div>

                        <div id="personal_msg_left">
                            <img id="personal_hp" src="${pageContext.request.contextPath}/image/hp.jpg"/>
                        </div>
                        <div id="personal_msg_center">
                            <div class="personal_message">
                                <div class="personal_intro">
                                    <span><b class="username">一生一知己</b></span>
                                </div>
                                <div class="personal_intro">
                                    联系方式：<span >未留下联系方式</span>
                                </div>
                                <div class="personal_message_banner"><b><i>个性签名:</i></b></div>
                                <div class="personal_message_content">跟你我确实没有神魔好说的</div>
                            </div>
                        </div>
                        <div id="personal_msg_right">

                            <ul>

                                <a href=""><li style="color:orange;"><i class="go">组织</i><i class="in">>>></i></li></a>
                                <a href=""><li style="color:pink;"><i class="go">活动</i><i class="in">>>></i></li></a>
                                <a href=""><li style="color:#08c;"><i class="go">动态</i><i class="in">>>></i></li></a>
                                <a href=""><li style="color:#00cc00;"><i class="go">资源</i><i class="in">>>></i></li></a>
                                <a href=""><li style="color:yellow;"><i class="go">通知</i><i class="in">>>></i></li></a>
                                <a href=""><li style="color:red;"><i class="go">消息</i><i class="in">>>></i></li></a>

                            </ul>

                        </div>
                    </div>

                </div>

                <div id="personal_container_bottom" class="shadow">

                        <div class="personal_banner">
                            <b><i>历史记录</i></b>
                        </div>

                        <section id="cd-timeline" class="cd-container">
                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-picture">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-picture.svg" alt="Picture">
                                </div><!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 1</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。<br><br><br><br><br><br><br><br><br><br><br><br></p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">2014-2-18</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 2</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">2014-3-18</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-picture">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-picture.svg" alt="Picture">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 3</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">2015-5-24</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-location">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-location.svg" alt="Location">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 4</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 14</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-location">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-location.svg" alt="Location">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 5</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 18</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                            <div class="cd-timeline-block">
                                <div class="cd-timeline-img cd-movie">
                                    <img src="${pageContext.request.contextPath}/image/timeLine/cd-icon-movie.svg" alt="Movie">
                                </div> <!-- cd-timeline-img -->

                                <div class="cd-timeline-content">
                                    <h2>html5时间表 6</h2>
                                    <p>jQuery 团队在官博中再次提醒用户，jQuery 2.0 不再支持IE 6/7/8 了，但是 jQuery 1.9 会继续支持。因为旧版 IE 浏览器在整个互联网中还有很大部分市场，所以他们非常期望大部分网站能继续使用 jQuery 1.x 一段时间。jQuery 团队也将同时支持 jQuery 1.x 和 2.x 。1.9 和 2.0 版的 API 是相同的，所以不必因为你们网站还在用 jQuery 1.9，就感觉好像错过了什么，或者是落后了。</p>
                                    <a href="#" class="cd-read-more">阅读更多</a>
                                    <span class="cd-date">Feb 26</span>
                                </div> <!-- cd-timeline-content -->
                            </div> <!-- cd-timeline-block -->

                        </section> <!-- cd-timeline -->

                </div>

            </div>
        </div>

    </div>

    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>

</div>

<!--加入隐藏背面-->
<div class="hideBack"></div>
<script src="${pageContext.request.contextPath}/js/timeLine/modernizr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>
<script>
    $(function(){
        var $timeline_block = $('.cd-timeline-block');
        //hide timeline blocks which are outside the viewport
        $timeline_block.each(function(){
            if($(this).offset().top > $(window).scrollTop()+$(window).height()*0.75) {
                $(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
            }
        });
        //on scolling, show/animate timeline blocks when enter the viewport
        $(window).on('scroll', function(){
            $timeline_block.each(function(){
                if( $(this).offset().top <= $(window).scrollTop()+$(window).height()*0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) {
                    $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
                }
            });
        });
    });
</script>
</body>
</html>

