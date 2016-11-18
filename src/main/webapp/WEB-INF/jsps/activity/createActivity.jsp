<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="content-type" charset="utf-8"/>
    <title>模态框</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        .no-resize {
            resize: none;
        }
        .err-info {
            color : red;
            font-size: 10px;
            font-family: "Micro YaHei";
        }
        input.set-height {
            height: 34px;
        }
        .create-activity-size {
            width: 700px;
            min-height: 300px;
        }
        .create-situation-size {
            width:700px;
            min-height:600px;
        }
    </style>
</head>
<body>

<div class="container-fluid">


    <div class="row">
        <div class="col-md-12">
            <a id="create-situation-nav" href="#" role="button" class="btn" data-toggle="modal">发布动态</a>
            <a id="create-activity-nav" href="#" role="button" class="btn" data-toggle="modal">发布活动</a>
            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br> <br><br><br><br><br><br><br> <br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br>
            111111
        </div>
    </div>
    <!--create-situation-dialog开始-->
    <div class="dialog shadow" id="create-situation-dialog">
        <div class="modal-content create-situation-size">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="situation-modal">
                    <strong>发布动态</strong>
                </h4>
            </div>
            <form method="post" class="form-horizontal" role="form" id="create-situation-form">
                <div class="modal-body" style="padding: 0px">
                    <!-- start row1-->
                    <div class="form-group" style="margin: 7px auto">
                        <label for="situation-name" class="col-sm-2 col-sm-offset-2 control-label">
                            动态名称:
                        </label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="situationName" id="situation-name" placeholder="例如:今天我们有一组非常漂亮的照片"/>
                            <div class="err-info"></div>
                        </div>
                    </div>
                    <!-- end of row1-->
                    <!--start row2-->
                    <div class="form-group" style="margin: 0px; padding: 0px">
                        <!-- 加载编辑器的容器 -->
                        <script id="situation-container" name="situationContent" type="text/plain">
                            动态主题
                        </script>
                    </div>
                    <!--end of row2-->
                </div>
                <div class="modal-footer">
                    <div class="row text-center">
                        <button type="button" class="btn btn-success" data-dismiss="modal">
                            发布
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            取消
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--create-situation-dialog结束-->



    <!--create-activity-dialog开始-->
    <div class="dialog shadow" id="create-activity-dialog">
        <div class="modal-content create-activity-size">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="activity-modal">
                    <strong>发布活动</strong>
                </h4>
            </div>
            <form method="post" class="form-horizontal" role="form" id="create-activity-form">
                <div class="modal-body">
                    <!-- start row1-->
                    <div class="form-group">
                        <label for="activity-name" class="col-sm-2 control-label">
                            活动名称:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="activityName" id="activity-name"
                                   placeholder="例如:ACM竞赛"/>
                            <div class="err-info"></div>
                        </div>
                        <label for="open" class="col-sm-2 control-label">
                            对外开放:
                        </label>
                        <div class="col-sm-4">
                            <select id="open" name="open" class="form-control">
                                <option value="1" selected>是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <!-- end of row1-->
                    <!-- start row2-->
                    <div class="form-group">
                        <label for="start-time" class="col-sm-2 control-label">
                            开始时间:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control laydate-icon set-height" name="startTime" id="start-time"
                                   placeholder="yyyy-MM-dd"/>
                            <div class="err-info"></div>
                        </div>
                        <label for="end-time" class="col-sm-2 control-label">
                            结束时间:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control laydate-icon set-height" name="endTime" id="end-time"
                                   placeholder="yyyy-MM-dd"/>
                            <div class="err-info"></div>
                        </div>
                    </div>
                    <!-- end of row2-->
                    <!-- start row3-->
                    <div class="form-group">
                        <label for="activity-member" class="col-sm-2 control-label">
                            活动人数:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="activityMember" id="activity-member"
                                   placeholder="例如:200"/>
                            <div class="err-info"></div>
                        </div>
                        <label for="location" class="col-sm-2 control-label">
                            活动地点:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="location" id="location" placeholder="例如:A7-310"/>
                            <div class="err-info"></div>
                        </div>
                    </div>
                    <!-- end of row3-->
                    <!--start row4-->
                    <div class="form-group" style="margin: 0px; padding: 0px; display: none;">
                        <script id="activity-container" name="activityContent" type="text/plain">
                            这里写你的发表活动的内容
                        </script>
                    </div>
                    <!--end of row4-->
                </div>
                <div class="modal-footer">
                    <div class="row text-center">
                        <button type="button" id="next-step" class="btn btn-primary">
                            下一步
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            取消
                        </button>
                        <button type="button" id="last-step" class="btn btn-primary" style="display: none">
                            上一步
                        </button>
                        <button type="button" class="btn btn-success" data-dismiss="modal" style="display: none">
                            提交
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
<script src="${pageContext.request.contextPath}/js/common/myDialog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/common/datepicker/laydate.dev.js"></script>
<!-- 配置文件 -->
<script src="${pageContext.request.contextPath}/common/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script src="${pageContext.request.contextPath}/common/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script src="${pageContext.request.contextPath}/common/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

    //调整浏览器分辨率做的事情
    //1.重新覆盖阴影  2.重新调整弹出框的位置
    $(window).resize(function () {
        dialog.reModify(parseInt($(".modal-content").css("min-height")), $(".modal-content").outerWidth());
    });


    //初始化发布活动编辑器
    var editor = UE.getEditor('activity-container', {
        initialFrameWidth: 698,
        initialFrameHeight:400,
        autoHeightEnabled: false,
        autoFloatEnabled: false,
        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo'],
            ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
        ]
    });

    //初始化发布动态编辑器
    var editor = UE.getEditor('situation-container', {
        initialFrameWidth: 698,
        initialFrameHeight:340,
        autoHeightEnabled: false,
        autoFloatEnabled: false,
        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo'],
            ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
        ]
    });

    $(function () {

        //下面是两个input输入框的日期插件调用
        $("#start-time, #end-time").on("click", function () {

            laydate({
                format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月日
                festival: true,//显示节日
                min: laydate.now(0)
            });
        });

        //点击创建活动按钮
        $("#create-activity-nav").on("click", function () {
            dialog.showDialog(parseInt($(".create-activity-size").css("min-height")),
                    $(".create-activity-size").outerWidth(), "create-activity-dialog");
        });

        //点击发布动态按钮
        $("#create-situation-nav").on("click", function () {
            dialog.showDialog(parseInt($(".create-situation-size").css("min-height")),
                    $(".create-situation-size").outerWidth(), "create-situation-dialog");
        });

        $(".dialog").on("click", "#next-step", function () {
           /*
            1.隐藏所有的基本信息输入框
            2.调整modal-content的高度
            3.改变一些基本的样式
            4.隐藏和显示modal-footer的一些图标
             */
           $(".create-activity-size .modal-body > div:lt(3)").css("display" , "none");
           $(".create-activity-size").css("min-height", 600);
           $(".create-activity-size .modal-body").css("padding", "0");
           $(".create-activity-size .modal-footer button:lt(2)").css("display", "none");
           $(".create-activity-size .modal-footer button:gt(1)").css("display", "inline-block");
            dialog.reModify(parseInt($(".create-activity-size").css("min-height")),
                    $(".create-activity-size").outerWidth());
            $(".create-activity-size .modal-body>div:eq(3)").css("display", "block");
        });

        $(".dialog").on("click", "#last-step", function () {
            /*
             还原当前dialog到基本信息页
             1.隐藏当前div
             2.还原按钮
             3.还原高度
             4.重写调整弹出框位置
             5.显示基本信息div
             */
            $(".create-activity-size .modal-body > div:eq(3)").css("display", "none");
            $(".create-activity-size .modal-footer button:lt(2)").css("display", "inline-block");
            $(".create-activity-size .modal-footer button:gt(1)").css("display", "none");
            $(".create-activity-size").css("min-height", 300);
            $(".create-activity-size .modal-body").removeAttr("style");
            dialog.reModify(parseInt($(".create-activity-size").css("min-height")), $(".create-activity-size").outerWidth());
            $(".create-activity-size .modal-body>div:lt(3)").css("display","block");
        });

        //当我们点击关闭模态框所做的事情
        $(".dialog").on("click", "button.close,.modal-footer button:eq(1)", function () {
             dialog.closeDialog();
        });
    });
</script>
</body>
</html>
