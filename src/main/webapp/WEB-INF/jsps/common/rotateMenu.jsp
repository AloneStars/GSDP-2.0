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
    <c:set var="Admin" value="${sessionScope.get('Admin')}"/>
    <c:set var="Member" value="${sessionScope.get('Member')}"/>
    <c:set var="Owner" value="${sessionScope.get('Owner')}"/>

    <c:choose>
        <c:when test="${Owner}">
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="组织信息管理" onclick="alert('组织信息管理');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
                </a>
            </div>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布资源" onclick="alert('发布资源');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
                </a>
            </div>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);"  title="发布活动" onclick="activity.clickActivity()">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
                </a>
            </div>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布动态" onclick="alert('发布动态');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
                </a>
            </div>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="发布通知" onclick="alert('发布通知');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
                </a>
            </div>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="成员管理" onclick="alert('成员管理');">
                    <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
                </a>
            </div>
            <div class="PathItem">
                <a class="link" href="javascript:void(0);" title="管理员管理" onclick="alert('管理员管理');">
                    <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
                </a>
            </div>
        </c:when>
        <c:otherwise>
            <c:if test="${Member}">
                <div class="PathItem">
                    <a class="link" href="javascript:void(0);" title="发布资源" onclick="alert('发布资源');">
                        <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
                    </a>
                </div>
                <c:if test="${Admin}">
                    <div class="PathItem">
                        <a class="link" href="javascript:void(0);"  title="发布活动" onclick="activity.clickActivity();">
                            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
                        </a>
                    </div>
                    <div class="PathItem">
                        <a class="link" href="javascript:void(0);" title="发布动态" onclick="alert('发布动态');">
                            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
                        </a>
                    </div>
                    <div class="PathItem">
                        <a class="link" href="javascript:void(0);" title="发布通知" onclick="alert('发布通知');">
                            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
                        </a>
                    </div>
                    <div class="PathItem">
                        <a class="link" href="javascript:void(0);" title="成员管理" onclick="alert('成员管理');">
                            <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
                        </a>
                    </div>
                    <div class="PathItem">
                        <a class="link" href="javascript:void(0);" title="管理员管理" onclick="alert('管理员管理');">
                            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
                        </a>
                    </div>
                </c:if>
            </c:if>
        </c:otherwise>
    </c:choose>

    <div class="PathItem">
        <a class="link" href="javascript:void(0);" title="创建团队" onclick="group.showCreateGroupDialog();">
            <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
        </a>
    </div>


    <div class="PathItem">
        <a class="link" href="javascript:void(0);" title="${Admin}">
            <span class="item" style="background-image: url('${pageContext.request.contextPath}/image/menu/moment_icn_address.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="javascript:void(0);" title="${Member}">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_pic.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="javascript:void(0);" title="11">
            <span class="item" style="background-image:url('${pageContext.request.contextPath}/image/menu/moment_icn_info.png');"></span>
        </a>
    </div>
    <div class="PathItem">
        <a class="link" href="javascript:void(0);" title="12">
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