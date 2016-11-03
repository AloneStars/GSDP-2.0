<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>团队大厅</title>
  <%@include file="common/style.jsp"%>
  <link href="${pageContext.request.contextPath}/css/groupList.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
  <jsp:include page="common/header.jsp"/>
  <!-- 内容版块 -->
  <div id="content-container">

    <div id="group_lobby" class="shadow">

      <div id="group_type">
        <div class="group_banner">
          <b><i>团体分类</i></b>
        </div>
        <ul id="type">
          <li class="shadow"><a href="${pageContext.request.contextPath}/group/1/list"><span
                  class="type_title">艺术类</span>
            <div class="type_icon icon1 shadow"></div>
            <div class="type_dec">浓郁的艺术气息是这类团体最好的介绍，不用犹豫这里才是最好的艺术天堂。</div></a></li>
          <li class="shadow"><a href="${pageContext.request.contextPath}/group/2/list"><span
                  class="type_title">公益类</span>
            <div class="type_icon icon2 shadow"></div>
            <div class="type_dec">这里是所有志愿者的集会，你的热心和热情在这里永远都会有最好的施展空间。</div></a></li>
          <li class="shadow"><a href="${pageContext.request.contextPath}/group/3/list"><span
                  class="type_title">文化类</span>
            <div class="type_icon icon3 shadow"></div>
            <div class="type_dec">这里书香四溢，文化的气息时时刻刻都会伴在你的左右，让我们一起在书籍的海洋中自由翱翔。</div></a></li>
          <li class="shadow"><a href="${pageContext.request.contextPath}/group/4/list"><span
                  class="type_title">科创类</span>
            <div class="type_icon icon4 shadow"></div>
            <div class="type_dec">炫酷的科技，神奇的科学，想要探索更为精巧的科学吗？和我们一起来吧！</div></a></li>
          <li class="shadow"><a href="${pageContext.request.contextPath}/group/5/list"><span
                  class="type_title">体育类</span>
            <div class="type_icon icon5 shadow"></div>
            <div class="type_dec">热爱运动，阳光，乐观，在烈日先尽情的挥洒汗水。和朋友一起运动才是最好的欢乐时光吗！</div></a></li>
          <li class="shadow"><a href="${pageContext.request.contextPath}/group/6/list"><span
                  class="type_title">素拓类</span>
            <div class="type_icon icon6 shadow"></div>
            <div class="type_dec">素质拓展类，这里你会体验到很多不同的文化和气息，你的校园生活永远会与众不同。</div></a></li>
        </ul>

      </div>

      <div id="group_list">
        <div class="group_banner">
          <b><i>团体列表</i></b>
        </div>
        <div id="group_container">
            <c:forEach items="${groupList}" var="group">
              <div class='group_list_item'>
                <a href="${pageContext.request.contextPath}/group/${group.groupId}/detail" target="_blank">
                  <div class='group_icon shadow' style="background:url('${pageContext.request.contextPath}/${group.groupIcon}')">
                  </div>
                  <span class='group_name'>${group.groupName}</span>
                </a>
              </div>
            </c:forEach>
        </div>
      </div>
    </div>
  </div>
  <!-- 页脚 -->
  <jsp:include page="common/footer.jsp"/>
</div>
  <form id="openWin" action="#" target="_blank" method="get"></form>
</body>
</html>

