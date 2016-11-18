<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" charset="utf-8"/>
    <title>加入组织模态框</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href="/GSDP/css/common/myDialog.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        .no-resize {
            resize: none;
        }
        .err-info {
            color : red;
            font-size: 10px;
            font-family: "Micro YaHei";
        }
    </style>
</head>
<body>

<div class="container-fluid">


    <div class="row">
        <div class="col-md-12">

            <a id="modal-679944" href="#" role="button" class="btn" data-toggle="modal"
               onclick="dialog.showDialog(300,400);">加入组织</a>


            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br>
            111111


        </div>
    </div>




<!--dialog开始-->
<div class="dialog shadow">

                    <div class="modal-content">
                        <div class="modal-header">

                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="dialog.closeDialog();">
                                ×
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                加入组织
                            </h4>
                        </div>

                        <form method="post" class="form-horizontal" role="form" id="join-group-form">

                        <div class="modal-body">
                            <div class="form-group">

                                <label for="contact" class="col-sm-4 control-label">
                                    手机号码:
                                </label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="contact" id="contact" placeholder="例如:13811111111"/>
                                    <div class="err-info"></div>
                                </div>
                            </div>

                            <div class="form-group">

                                <label class="col-sm-4 control-label">
                                    申请理由:
                                </label>
                                <div class="col-sm-7">
                                    <textarea name="apply-reason" id="apply-reason" class="no-resize form-control" rows="5" placeholder="例如:我能够在这个社团学到很多的东西"></textarea>
                                    <div class="err-info"></div>
                                </div>

                            </div>


                        </div>


                        <div class="modal-footer">
                            <div class="row text-center">
                            <button type="button" class="btn btn-primary">
                                确定
                            </button>

                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="dialog.closeDialog();">
                                取消
                            </button>
                            </div>
                        </div>

                            </form>
                    </div>
</div>
<!--dialog结束-->

<!--隐藏背面-->
<div class="hideBack"></div>


</div>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="/GSDP/js/common/myDialog.js" type="text/javascript"></script>
<script type="text/javascript">
    //调整浏览器分辨率做的事情
    //1.重新覆盖阴影  2.重新调整弹出框的位置
    $(window).resize(function () {
        dialog.reModify(300, 400);
    });
</script>
</body>
</html>
