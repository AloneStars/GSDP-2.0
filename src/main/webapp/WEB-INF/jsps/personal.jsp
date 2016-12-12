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
    <link href="${pageContext.request.contextPath}/css/pathMenu/hover-effects.css" type="text/css" rel="stylesheet">
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
                            <img id="personal_hp" src="${pageContext.request.contextPath}/${queryUser.headPicture}"/>
                        </div>
                        <div id="personal_msg_center">
                            <div class="personal_message">
                                <div class="personal_intro">
                                    <span><b class="username">${queryUser.username}</b></span>
                                </div>
                                <div class="personal_intro">
                                    联系方式：<span >${queryUser.loginEmail}</span>
                                </div>
                                <div class="personal_message_banner"><b><i>个性签名:</i></b></div>
                                <div class="personal_message_content">${queryUser.userDec}</div>
                            </div>
                        </div>
                        <div id="personal_msg_right">

                            <ul>
                                <c:if test="${queryUser.userId == user.userId}">
                                    <a href="#noticeHistory"><li style="color:yellow;" ><i class="go">通知</i><i class="in">>>></i></li></a>
                                    <a href="#newsHistory"><li style="color:red;" ><i class="go">消息</i><i class="in">>>></i></li></a>
                                </c:if>
                                <a href="#activityHistory"><li style="color:pink;" ><i class="go">活动</i><i class="in">>>></i></li></a>
                                <a href="#situationHistory"><li style="color:#08c;" ><i class="go">动态</i><i class="in">>>></i></li></a>
                                <a href="#resourceHistory"><li style="color:#00cc00;" ><i class="go">资源</i><i class="in">>>></i></li></a>
                                <a href="#groupHistory"><li style="color:orange;"><i class="go">组织</i><i class="in">>>></i></li></a>
                            </ul>

                        </div>
                    </div>

                </div>

                <div id="personal_container_bottom" class="shadow">

                    <c:if test="${queryUser.userId == user.userId}">

                        <div id="noticeHistory">
                            <div class="personal_banner" onclick="Toggle('#noticeHistory_container');">
                                <b><i>通知历史记录</i></b>
                            </div>

                            <div id="noticeHistory_container">

                                <section  class="cd-timeline cd-container">

                                    <c:forEach var="notice" items="${noticeList}">

                                        <div class="cd-timeline-block">
                                            <div class="cd-timeline-img ">
                                                <img src="${pageContext.request.contextPath}/${notice.group.groupIcon}" title="${notice.group.groupName}">
                                            </div><!-- cd-timeline-img -->

                                            <div class="cd-timeline-content">
                                                <h2>通知消息</h2>
                                                <p>${notice.noticeContent}</p>
                                                <%--<a href="" class="cd-read-more" target="_blank">阅读更多</a>--%>
                                                <span class="cd-date">${notice.noticeTime}</span>
                                            </div> <!-- cd-timeline-content -->
                                        </div> <!-- cd-timeline-block -->

                                    </c:forEach>

                                </section> <!-- cd-timeline -->

                            </div>

                        </div>

                        <div id="newsHistory">

                            <div class="personal_banner" onclick="Toggle('#newsHistory_container');">
                                <b><i>消息历史记录</i></b>
                            </div>

                            <div id="newsHistory_container">

                                <section class="cd-timeline cd-container">

                                    <c:forEach var="news" items="#{newsList}">

                                        <div class="cd-timeline-block">

                                            <div class="cd-timeline-img ">
                                                <img src="${pageContext.request.contextPath}/${user.headPicture}" title="${queryUser.username}">
                                            </div><!-- cd-timeline-img -->

                                            <div class="cd-timeline-content">
                                                <h2>${news.newsTitle}</h2>
                                                <p>${news.newsContent}</p>
                                                <c:choose>
                                                    <c:when test="${news.statue == 0}">
                                                        <a href="javascript:void(0);" class="cd-read-more" onclick="user.changeNewsStatue(${news.newsId},arguments[0]);">未读</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="javascript:void(0);" class="cd-read-more">已读</a>
                                                    </c:otherwise>
                                                </c:choose>
                                                <span class="cd-date">${news.sendTime}</span>
                                            </div> <!-- cd-timeline-content -->
                                        </div> <!-- cd-timeline-block -->

                                    </c:forEach>

                                </section> <!-- cd-timeline -->

                            </div>

                        </div>

                    </c:if>

                    <div id="activityHistory">

                        <div class="personal_banner" onclick="Toggle('#activityHistory_container');">
                            <b><i>活动历史记录</i></b>
                        </div>

                        <div id="activityHistory_container">

                            <section  class="cd-timeline cd-container">

                                <c:forEach var="activity" items="#{activityList}">

                                    <div class="cd-timeline-block">
                                        <div class="cd-timeline-img ">
                                            <img src="${pageContext.request.contextPath}/${activity.group.groupIcon}" title="${activity.group.groupName}">
                                        </div><!-- cd-timeline-img -->

                                        <div class="cd-timeline-content">
                                            <h2>${activity.group.groupName}</h2>
                                            <p>${activity.activityTitle}</p>
                                            <a href="${pageContext.request.contextPath}/activity/${activity.activityId}/detail" class="cd-read-more" target="_blank">阅读更多</a>
                                            <span class="cd-date">${activity.publishTime}</span>
                                        </div> <!-- cd-timeline-content -->
                                    </div> <!-- cd-timeline-block -->

                                </c:forEach>


                            </section> <!-- cd-timeline -->

                        </div>

                    </div>

                    <div id="situationHistory">
                        <div class="personal_banner" onclick="Toggle('#situationHistory_container');">
                            <b><i>动态历史记录</i></b>
                        </div>

                        <div id="situationHistory_container">

                            <section  class="cd-timeline cd-container">

                                <c:forEach var="situation" items="#{situationList}">

                                    <div class="cd-timeline-block">
                                        <div class="cd-timeline-img">
                                            <img src="${pageContext.request.contextPath}/${situation.group.groupIcon}" title="${situation.group.groupName}">
                                        </div><!-- cd-timeline-img -->

                                        <div class="cd-timeline-content">
                                            <h2>${situation.group.groupName}</h2>
                                            <p>${situation.situationTitle}</p>
                                            <a href="${pageContext.request.contextPath}/situation/${situation.situationId}/detail" class="cd-read-more" target="_blank">阅读更多</a>
                                            <span class="cd-date">${situation.publishTime}</span>
                                        </div> <!-- cd-timeline-content -->
                                    </div> <!-- cd-timeline-block -->
                                </c:forEach>

                            </section> <!-- cd-timeline -->

                        </div>

                    </div>

                    <div id="resourceHistory">
                        <div class="personal_banner" onclick="alert('改模块还在开发中，请稍后...');">
                            <b><i>资源历史记录</i></b>
                        </div>

                        <div id="resourceHistory_container">

                        </div>

                    </div>

                    <div id="groupHistory">

                        <div class="personal_banner" onclick="Toggle('#groupHistory_container');">
                            <b><i>组织历史纪录</i></b>
                        </div>

                        <div id="groupHistory_container">

                            <div id="createdGroup">
                                <div class="personal_banner">
                                    <b><i>他创建的组织</i></b>
                                </div>

                                <c:forEach var="createdGroup" items="#{createdGroupList}">

                                    <div class="group_list_item port-2 effect-3">
                                        <div class="image-box">
                                            <img src="${pageContext.request.contextPath}/${createdGroup.groupIcon}" alt="Image-1"/>
                                        </div>
                                        <div class="text-desc">
                                            <h3>${createdGroup.groupName}</h3>
                                            <p>${createdGroup.groupDec}</p>
                                            <a href="${pageContext.request.contextPath}/group/${createdGroup.groupId}/detail" class="btn" target="_blank">Learn more</a>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>

                            <div id="joinedGroup">
                                <div class="personal_banner">
                                    <b><i>他加入的组织</i></b>
                                </div>

                                <c:forEach var="joinedGroup" items="#{joinedGroupList}">

                                    <div class="group_list_item port-2 effect-3">
                                        <div class="image-box">
                                            <img src="${pageContext.request.contextPath}/${joinedGroup.groupIcon}" alt="Image-1"/>
                                        </div>
                                        <div class="text-desc">
                                            <h3>${joinedGroup.groupName}</h3>
                                            <p>${joinedGroup.groupDec}</p>
                                            <a href="${pageContext.request.contextPath}/group/${joinedGroup.groupId}/detail" class="btn" target="_blank">Learn more</a>
                                        </div>
                                    </div>

                                </c:forEach>

                            </div>

                        </div>

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

    function Toggle(divClass){
        $(divClass).slideToggle("slow");
    };
</script>
</body>
</html>


