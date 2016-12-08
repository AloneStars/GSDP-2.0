<%--
  Created by IntelliJ IDEA.
  User: ViolentStone
  Date: 2016/11/9
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="PathInner" id="PathMenu" style=" margin:250px auto;">
    <div class="PathMain">
        <div class="Tmain" onclick="PathRun();">
            <div class="rotate"><span class="cover"></span></div>
        </div>
    </div>

    <c:set var="groupId" value="${group.groupId}"/>
    <c:forEach items="${sessionScope.get('identities')}" var="map">
        <c:if test="${map.key == groupId}">
            <c:set var="identity" value="${map.value}"/>
        </c:if>
        <%--${map.key},${map.value}--%>
    </c:forEach>

    <%--<div>....${groupId},${identity}</div>--%>
    <c:choose>
        <c:when test="${identity == 'owner'}">
            <%--组织信息管理--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="组织信息管理" onclick="alert('组织信息管理');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/GroupMsg.png');"></span>
                </a>
            </div>
            <%--发布资源--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布资源" onclick="alert('发布资源');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Resource.png');"></span>
                </a>
            </div>
            <%--发布活动--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);"  title="发布活动" onclick="activity.clickActivity()">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Activity.png');"></span>
                </a>
            </div>
            <%--发布动态--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布动态" onclick="situation.showCreateSituation();">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Situation.png');"></span>
                </a>
            </div>
            <%--发布通知--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布通知" onclick="notice.showPublishNotice();">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Notice.png');"></span>
                </a>
            </div>
            <%--成员管理--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="成员管理"  onclick="group.showGroupMemberManager();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/Member.png');"></span>
                </a>
            </div>
            <%--成员申请管理--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="成员申请管理"  onclick="group.showGroupApplyMemberManager();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/Member.png');"></span>
                </a>
            </div>
            <%--创建团队--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="创建团队" onclick="group.showCreateGroupDialog();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
                </a>
            </div>
        </c:when>
        <c:when test="${identity == 'admin'}">
            <%--发布资源--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布资源" onclick="alert('发布资源');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Resource.png');"></span>
                </a>
            </div>
            <%--发布活动--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);"  title="发布活动" onclick="activity.clickActivity()">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Activity.png');"></span>
                </a>
            </div>
            <%--发布动态--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布动态" onclick="situation.showCreateSituation();">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Situation.png');"></span>
                </a>
            </div>
            <%--发布通知--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布通知" onclick="notice.showPublishNotice();">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Notice.png');"></span>
                </a>
            </div>
            <%--成员管理--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="成员管理" onclick="group.showGroupMemberManager();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/Member.png');"></span>
                </a>
            </div>
            <%--成员申请管理--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="成员申请管理"  onclick="group.showGroupApplyMemberManager();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/Member.png');"></span>
                </a>
            </div>
            <%--创建团队--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="创建团队" onclick="group.showCreateGroupDialog();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
                </a>
            </div>
        </c:when>
        <c:when test="${identity == 'member'}">
            <%--发布资源--%>
            <div class="PathItem">
                    <a class="link" href="javascript:void(0);" title="发布资源" onclick="alert('发布资源');">
                        <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/Resource.png');"></span>
                    </a>
            </div>
            <%--成员管理--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="成员管理" onclick="group.showGroupMemberManager();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/Member.png');"></span>
                </a>
            </div>
            <%--创建团队--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="创建团队" onclick="group.showCreateGroupDialog();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
                </a>
            </div>
        </c:when>
        <c:when test="${identity == 'visitor'}">
            <%--创建团队--%>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="创建团队" onclick="group.showCreateGroupDialog();">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
                </a>
            </div>
        </c:when>
    </c:choose>
</div>

<!--创建活动的模态框-->
<%@ include file="../dialog/createActivity.jsp"%>
<!--发布动态的模态框-->
<%@ include file="../dialog/createSituation.jsp"%>
<!--创建组织模态框-->
<%@ include file="../dialog/createGroup.jsp"%>
<!--申请加入组织模态框-->
<%@ include file="../dialog/joinGroup.jsp"%>
<!--申请团队的成员管理模态框-->
<%@ include file="../dialog/groupApplyMemberManager.jsp"%>
<%--发布通知的模态框--%>
<%@ include file="../dialog/publishNotice.jsp"%>
<!--团队成员管理的模态框-->
<%@ include file="../dialog/groupMemberManager.jsp"%>
