<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>修改密码</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        .err-info {
            color : red;
            font-size: 10px;
            font-family: "Micro YaHei";
        }
        .modify-password-modal-size {
            width: 500px;
            min-height: 300px;
        }
    </style>
</head>
<body>
<div class="container-fluid">


    <div class="row">
        <div class="col-md-12">

            <a id="modify-password-nav" href="#" role="button" class="btn" data-toggle="modal"
               >修改密码</a>

            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br>
            111111


        </div>
    </div>

</div>

<!--生成所有的dialog-->
<div class="dialog shadow"></div>
<!--dialog结束-->

<!--隐藏背面-->
<div class="hideBack"></div>

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="/GSDP/js/common/myDialog.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user.js"></script>
<script type="text/javascript">

    //调整浏览器分辨率做的事情
    //1.重新覆盖阴影  2.重新调整弹出框的位置
    $(window).resize(function () {
        dialog.reModify(parseInt($(".modal-content").css("min-height")), $(".modal-content").outerWidth());
    });

    $(function () {
        //打开弹出框
        $("#modify-password-nav").on("click", function () {
            $(".dialog").html($("#modify-password").html());
            dialog.showDialog(parseInt($(".modal-content").css("min-height")), $(".modal-content").outerWidth());
        });
        //关闭弹出框
        $(".dialog").on("click", ".close, .modal-footer button:eq(1)", function () {
            dialog.closeDialogWithJs();
        });
    });
</script>

<!--给 script 设置type= text/template ,标签里面的内容不会被执行,也不会显示在页面上,但是可以在另一个script里面通过获取-->
<script type="text/template" id="modify-password">
    <div class="modal-content modify-password-modal-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title">
                <b>修改密码</b>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="modify-password-form">
            <!--start body-->
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="old-password" class="col-sm-4 control-label">
                                原密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="oldPassword" id="old-password"
                                       placeholder="6-16位密码, 区分大小写, 非空白字符"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="new-password" class="col-sm-4 control-label">
                                新密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="new-password" name="newPassword"
                                       placeholder="6-16位密码, 区分大小写, 非空白字符"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirm-password" class="col-sm-4 control-label">
                                确认密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="confirm-password" name="confirmPassword"
                                       placeholder="6-16位密码, 区分大小写, 非空白字符"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--end of body-->
            <div class="modal-footer">
                <div class="row">
                    <button type="button" class="btn btn-primary col-sm-2 col-sm-offset-4" id="modify">
                        修改
                    </button>
                    <button type="button" class="btn btn-default col-sm-2" data-dismiss="modal">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</script>
</body>
</html>
