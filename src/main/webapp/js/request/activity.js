/**
 * Created by ViolentStone on 2016/11/16.
 * 活动相关的js请求控制
 */

var activity = {

    "url" :{
        //获取发布用户连接
        "activityCreation"  : function() {
            return "/gsdp/activity/creation";
        }
    },

    "checkNull" : function(activityName){

        if(Trim(activityName,"g") == "" ||isUndefine(activityName))
            return false;
        else
            return true;
    },

    "checkNumber" : function (activityNumber) {

        if(Trim(activityNumber,"g") == "")
            return false;
        else{

            var number = Number(activityNumber);

            if(!isNaN(number))
            {
                if(parseInt(number) == number)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }

    },

    "checkDate" : function(startTime,endTime){

        if(stringToDate(endTime) < stringToDate(startTime))
            return false;
        else
            return true;
    },

    "clickActivity" : function () {
        dialog.showDialog(parseInt($(".create-activity-size").css("min-height")),
            $(".create-activity-size").outerWidth(), "create-activity-dialog");
    },

    "checkNestStep" : function(activityName,activityMember,location,startTime,endTime){

        if(!activity.checkNull(activityName)){
            $("#activity-name").next(".err-info").html("活动名称不能为空");
            return false;
        }
        else
            $("#activity-name").next(".err-info").html("");

        if(startTime == ""){
            $("#start-time").next(".err-info").html("请选择活动起始时间");
            return false;
        }
        else
            $("#start-time").next(".err-info").html("");

        if(endTime == ""){
            $("#end-time").next(".err-info").html("请选择活动结束时间");
            return false;
        }
        else
            $("#end-time").next(".err-info").html("");

        
        if(!activity.checkDate(startTime,endTime)){
            $("#end-time").next(".err-info").html("活动结束日期不能比开始日期早");
            return false;
        }
        else
            $("#end-time").next(".err-info").html("");

        if(!activity.checkNumber(activityMember)){
            $("#activity-member").next(".err-info").html("活动人数不能为空，也必须为整数");
            return false;
        }
        else
            $("#activity-member").next(".err-info").html("");

        if(!activity.checkNull(location)){
            $("#location").next(".err-info").html("活动地点不能为空");
            return false;
        }
        else
            $("#location").next(".err-info").html("");


        return true;
    },

    "activityCreation" : function() {

        var activityName = $("#activity-name").val();
        var open = $("#open").val();
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();
        var activityNumber = $("#activity-member").val();
        var location = $("#location").val();
        var content = editor.getContent();

        $.ajax({
            type:"post",
            url: activity.url.activityCreation(),
            dataType:"json",
            data:{
                "activityName" : activityName,
                "open" : open,
                "startTime" : startTime,
                "endTime" : endTime,
                "activityNumber" : activityNumber,
                "location" : location,
                "content" : content
            },
            success:function(msg){
                //这里使用JSON.parse始终解析不到相应的数据
                var json = eval(msg);
                alert(json.context);
            },
            error:function(jqXHR){
                alert("发生错误:"+jqXHR.status);
            }
        });

    },
}

$(function(){

    //下面是两个input输入框的日期插件调用
    $("#start-time, #end-time").on("click", function () {

        laydate({
            format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月日
            festival: true,//显示节日
            min: laydate.now(0)
        });
    });

    $("#next-step").on("click",function(){

        var activityName = $("#activity-name").val();
        var activityMember = $("#activity-member").val();
        var location = $("#location").val();
        var startTime = $("#start-time").val();
        var endTime = $("#end-time").val();

        if(activity.checkNestStep(activityName,activityMember,location,startTime,endTime)){
            setTimeout(function () {
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
            },100);

        }

    });

    $("#last-step").on("click", function () {
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

    $("#submit").on("click",function(){
        activity.activityCreation();
    });

});

//初始化发布活动编辑器
var activityEditor = UE.getEditor('activity-container', {
    initialFrameWidth: 698,
    initialFrameHeight:340,
    autoHeightEnabled: false,
    autoFloatEnabled: false,
    toolbars: [
        [
            'anchor', //锚点
            'undo', //撤销
            'redo', //重做
            'bold', //加粗
            'indent', //首行缩进
            'snapscreen', //截图
            'italic', //斜体
            'underline', //下划线
            'strikethrough', //删除线
            'subscript', //下标
            'fontborder', //字符边框
            'superscript', //上标
            'formatmatch', //格式刷
            'source', //源代码
            'blockquote', //引用
            'pasteplain', //纯文本粘贴模式
            'selectall', //全选
            'print', //打印
            'preview', //预览
            'horizontal', //分隔线
            'removeformat', //清除格式
            'time', //时间
            'date', //日期
            'unlink', //取消链接
            'insertrow', //前插入行
            'insertcol', //前插入列
            'mergeright', //右合并单元格
            'mergedown', //下合并单元格
            'deleterow', //删除行
            'deletecol', //删除列
            'splittorows', //拆分成行
            'splittocols', //拆分成列
            'splittocells', //完全拆分单元格
            'deletecaption', //删除表格标题
            'inserttitle', //插入标题
            'mergecells', //合并多个单元格
            'deletetable', //删除表格
            'cleardoc', //清空文档
            'insertparagraphbeforetable', //"表格前插入行"
            'insertcode', //代码语言
            'fontfamily', //字体
            'fontsize', //字号
            'paragraph', //段落格式
            'simpleupload', //单图上传
            'insertimage', //多图上传
            'edittable', //表格属性
            'edittd', //单元格属性
            'link', //超链接
            'emotion', //表情
            'spechars', //特殊字符
            'searchreplace', //查询替换
            'map', //Baidu地图
            'gmap', //Google地图
            'insertvideo', //视频
            'help', //帮助
            'justifyleft', //居左对齐
            'justifyright', //居右对齐
            'justifycenter', //居中对齐
            'justifyjustify', //两端对齐
            'forecolor', //字体颜色
            'backcolor', //背景色
            'insertorderedlist', //有序列表
            'insertunorderedlist', //无序列表
            'fullscreen', //全屏
            'directionalityltr', //从左向右输入
            'directionalityrtl', //从右向左输入
            'rowspacingtop', //段前距
            'rowspacingbottom', //段后距
            'pagebreak', //分页
            'insertframe', //插入Iframe
            'imagenone', //默认
            'imageleft', //左浮动
            'imageright', //右浮动
            'attachment', //附件
            'imagecenter', //居中
            'wordimage', //图片转存
            'lineheight', //行间距
            'edittip ', //编辑提示
            'customstyle', //自定义标题
            'autotypeset', //自动排版
            'webapp', //百度应用
            'touppercase', //字母大写
            'tolowercase', //字母小写
            'background', //背景
            'template', //模板
            'scrawl', //涂鸦
            'music', //音乐
            'inserttable', //插入表格
            'drafts', // 从草稿箱加载
            'charts', // 图表
        ]
    ]
});
