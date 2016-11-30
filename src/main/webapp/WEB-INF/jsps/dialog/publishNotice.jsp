<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>发布通知</title>
    <%@ include file="../common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/dialogCss.css" rel="stylesheet"/>
</head>
<body>

<a href="javascript:group.showPublishNotice();">发布通知</a>

<!--publishNotice dialog开始-->
<div class="dialog dialog-shadow" id="publish-notice-dialog">
    <div class="modal-content publish-notice-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title" id="publish-notice-modal">
                <strong>发布通知</strong>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="publish-notice-form">
            <div class="modal-body">
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="notice-content">
                        通知内容:
                    </label>
                    <div class="col-sm-7">
                        <textarea name="notice-content" id="notice-content" class="no-resize form-control" rows="7"
                                  placeholder="例如:明天我们要开一场会"></textarea>
                        <div class="err-info"></div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="row text-center">
                    <button type="button" class="btn btn-primary">
                        确定
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--joinGroup dialog结束-->

<div class="hideBack"></div>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/request/group.js"></script>
</body>
</html>
