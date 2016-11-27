/**
 * Created by ViolentStone on 2016/11/25.
 */
$(function(){

    var totalPage = $("#totalPage").html();
    var currentPage = $("#currentPage").html();
    var showData = $("#showData").html();

    var pagination = new Pagination(totalPage,currentPage,showData);

    $('.M-box').pagination({
        callback:function(index){
            $('.now').text(index);
        }
    },function(api){
        $('.now').text(api.getCurrent());
    });

    $('.M-box2').pagination({
        coping:true,
        homePage:'首页',
        endPage:'末页',
        prevContent:'上页',
        nextContent:'下页'
    });

    $('.M-box1').pagination({
        totalData:100,
        showData:5,
        coping:true
    });

    $('.M-box3').pagination({
        pageCount:pagination.totalPage,
        jump:true,
        coping:true,
        homePage:'首页',
        endPage:'末页',
        prevContent:'上页',
        nextContent:'下页',
        callback: function (api) {
            paginationActivity(api.getCurrent(),pagination.showData);
            $("#currentPage").html(api.getCurrent());
        }
    });
});

var url = {
    "activityPagination" : function(){
        return "/gsdp/activity/pagination";
    }
};

function Pagination(totalPage,currentPage,showData){

    this.totalPage = totalPage;
    this.currentPage = currentPage;
    this.showData = showData;

    this.SetCurrentPage = function(totalPage){
        this.totalPage = totalPage;
    };
    this.SetCurrentPage = function(totalPage){
        this.totalPage = totalPage;
    };
    this.SetCurrentPage = function(totalPage){
        this.totalPage = totalPage;
    };
};

function paginationActivity(currentPage,showData){

    $.ajax({
        type:"post",
        url: url.activityPagination(),
        dataType: "json",
        data:{
            currentPage:currentPage,
            showData:showData
        },
        success: function(msg){
            var json = eval(msg).data;
            $("#AllActivity").empty();
            for (var i = 0; i < json.length; i++) {
                var activityId = json[i].activityId;
                var activityTitle =  json[i].activityTitle;
                var publishTime = json[i].publishTime;

                var address = getRootPath()+"/activity/"+activityId+"/detail";
                $("#AllActivity").append("<li><a href="+address+" target='_blank'><span class='title'>"+activityTitle+"</span></a><span class='time'>发布时间:&nbsp;<i>"+publishTime+"</i></span></li>");

            }
        },
        error: function(jqXHR){
            alert("发生错误:"+jqXHR.status);
        }

    });
};

//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(projectName);
}
