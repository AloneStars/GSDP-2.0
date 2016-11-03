<%--
  测试发布活动模块
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>创建团队申请</title>
    <link href="/GSDP/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="/GSDP/css/common/myDialog.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        .group_intro_text {
            resize: none;
            width: 100%;
            height: 100px;
            padding-left: 7px;
            border-radius: 4px;
        }

        .file {
            position: relative;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 5px 12px;
            overflow: hidden;
            margin-top: 1px;
            color: #666;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }

        .file input {
            position: absolute;
            font-size: 20px;
            right: 0;
            top: 0;
            opacity: 0;
        }

        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
        .text-red {
            color : red;
        }
    </style>
</head>
<body>

<div class="container-fluid">


    <div class="row">
        <div class="col-md-12">

            <a id="modal-679944" href="#" role="button" class="btn" data-toggle="modal"
               onclick="dialog.showDialog(545,465);">创建团队</a>

            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br>
            111111


        </div>
    </div>

</div>

<!--生成所有的dialog-->
<div class="dialog shadow">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="dialog.closeDialog();">
                ×
            </button>
            <h4 class="modal-title" id="modal_create_group_title">
                <b>创建团队</b>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="group_creation_form"
              enctype="multipart/form-data">
            <div class="modal-body">
                <!--start body-->
                <div class="row">
                    <div class="col-md-12">

                        <div class="form-group">

                            <label for="group_name" class="col-sm-4 control-label">
                                团队名称:
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="groupName" id="group_name" placeholder="例如:星空摄影团队"/>
                                <div class="text-danger"></div>
                            </div>
                        </div>
                        <div class="form-group">

                            <label for="contact" class="col-sm-4 control-label">
                                联系方式(电话):
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="contact"
                                        name="groupContact" placeholder="例如:13811111111"/>
                                <div class="text-danger"></div>
                            </div>

                        </div>

                        <div class="form-group">

                            <label for="work_address" class="col-sm-4 control-label">
                                办公地点:
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="work_address"
                                       name="groupAddress" placeholder="例如:A7-310"/>
                                <div class="text-danger"></div>
                            </div>

                        </div>

                        <div class="form-group">

                            <label for="group_type" class="col-sm-4 control-label">
                                团队类型:
                            </label>
                            <div class="col-sm-7">
                                    <select id="group_type" class="form-control" name="groupType">
                                        <option selected value="1">艺术类</option>
                                        <option value="2">公益类</option>
                                        <option value="3">文化类</option>
                                        <option value="4">科创类</option>
                                        <option value="5">体育类</option>
                                        <option value="6">素拓类</option>
                                    </select>
                                <div class="text-danger"></div>
                            </div>

                        </div>

                        <div class="form-group">

                            <label for="profile" class="col-sm-4 control-label">
                                佐证材料:
                            </label>
                            <div class="col-sm-7">
                                <a href="javascript:;" class="file form-control">选择文件
                                    <input type="file" name="checkFile" id="profile" accept="image/jpeg,image/jpg,application/msword">
                                </a>
                                <div class="text-danger"></div>
                            </div>
                        </div>

                        <div class="form-group">

                            <label class="col-sm-4 control-label">
                                团队介绍:
                            </label>
                            <div class="col-sm-7">
                                <textarea name="groupDec" id="group_introduce" class="group_intro_text" placeholder="例如:我们团队是一支摄影团队..."></textarea>
                                <div class="text-danger"></div>
                            </div>

                        </div>

                        <div class="text-center text-red">
                            注意:佐证材料的格式必须是jpg,jpeg,doc.大小不超过5m
                        </div>


                    </div>
                </div>
                <!--end of body-->
            </div>

            <div class="modal-footer">

                <div class="row">
                    <button type="submit" class="btn btn-primary col-sm-2 col-sm-offset-4">
                        确定
                    </button>
                    <button type="reset" class="btn btn-default col-sm-2" data-dismiss="modal"
                            onclick="dialog.closeDialog();">
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
<!--footer-->
<script src="/GSDP/js/jquery.js" type="text/javascript"></script>
<script src="/GSDP/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/GSDP/js/common/myDialog.js" type="text/javascript"></script>
<script src="/GSDP/js/group.js" type="text/javascript"></script>

<script type="text/javascript">

    //调整浏览器分辨率做的事情
    //1.重新覆盖阴影  2.重新调整弹出框的位置
    $(window).resize(function () {
        dialog.reModify(545, 465);
    });

    $("#group_creation_form").on("change", "input#profile", function () {
        var value = $(this).val();
        var text = this.previousSibling;
        while (text && text.nodeType != 3) {
            text = text.previousSibling;
        }
        if (text && text.nodeType == 3) {
            if(value) {
                text.nodeValue = value.substring(value.lastIndexOf("\\") + 1);
            } else {
                text.nodeValue = "选择文件";
            }
        }
    });
    
    $("#group_creation_form").on("submit",function () {
        if(group.groupCreation()) {
            this.action = group.url.groupCreation();
            $(this).submit;
        } else {
            return false;
        }
    });
</script>
</body>
</html>

