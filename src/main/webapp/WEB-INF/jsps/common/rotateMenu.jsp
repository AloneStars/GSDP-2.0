<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/9
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<div class="PathInner" id="PathMenu" style=" margin:250px auto;">
    <div class="PathMain">
        <div class="Tmain" onclick="PathRun();">
            <div class="rotate"><span class="cover"></span></div>
        </div>
    </div>
    <div class="PathItem">
        <a class="link" href="#"  title="1">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="2">
            <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');" onclick="activity.clickActivity()"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="3" onclick="activity.clickActivity()">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="4" onclick="group.showCreateGroupDialog();">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="5">
            <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="6">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="7">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="8">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="9">
            <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="10">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="11">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="#" title="12">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
        </a>
    </div>
</div>

<!--创建活动的模态框-->
<%@ include file="../dialog/createActivity.jsp"%>
<!--发布动态的模态框-->
<%@ include file="../dialog/createSituation.jsp"%>
<!--创建组织模态框-->
<%@ include file="../dialog/createGroup.jsp"%>

<!--隐藏背面所做的事情-->
<div class="hideBack"></div>