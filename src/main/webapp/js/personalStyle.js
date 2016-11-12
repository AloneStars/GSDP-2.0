/**
 * Created by yizijun on 2016/7/28 0028.
 */

/**
 * 完成导航栏和内容的对应关系
 */
$(function(){

    $("ul.nav_ul li").on("click",function(){
        var $allLi = $("ul.nav_ul li");
        var index = $allLi.index(this);
        $(this).children().css("color","red");
        //change the nav show or hidden,and notice this method!!!
        $("ul.nav_ul li:not(:eq(" + index + ")) a").css("color","black");

        //change the nav_content show or hidden
        var func = function(){
         $(".navigation_content div[id$='_content']:not(:eq(" + index + "))").attr("style","display:none");
         $(".navigation_content div[id$='_content']:eq(" + index + ")").attr("style","display:block");
     }
        setTimeout(func,500);
    });
});


/**
 * 打开输入内容的对话框
 */
function showDialog() {
    var $hidebg = $("div.hidebg");
    var $dialog = $("div.dialog");
    $hidebg.css("height",document.body.scrollHeight + "px");
    $hidebg.show();

    //当我们修改dialog的时候，我们就只改变这个方法
    modifyPasswordDialog();
    changeDialogPosition(changeSizeToNumber($dialog.css("width")),changeSizeToNumber($dialog.css("height")));
    $dialog.fadeIn("slow");
}
/**
 * 关闭输入内容的对话框
 */
function closeDialog() {
    var $dialog = $("div.dialog");
    $("div.hidebg").hide();
    $dialog.hide("slow");
    $dialog.empty();
}

/**
 * 根据Dialog的高度和宽度来动态的决定其显示的位置
 * @param height dialog的高度
 * @param width dialog的宽度
 */
function changeDialogPosition(height,width) {
    var $dialog = $("div.dialog");
    var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
    var clientWidth = document.documentElement.clientWidth || document.body.clientWidth;
    console.log("clientHeight =" + clientHeight);
    console.log("clientWidth =" + clientWidth);
    $dialog.css("top",(clientHeight-height) / 2);
    $dialog.css("left",(clientWidth-width) / 2);
}

/**
 *设置dialog的width和height
 * @param height
 * @param width
 */
function setDialogWidthAndHeight(height,width) {
    var $dialog = $("div.dialog");
    $dialog.css("min-height",height);
    $dialog.css("width",width);
}

/**
 *
 */
function modifyPasswordDialog() {

    setDialogWidthAndHeight(320,400);

    var dialog = "<div class='modify_password_nav'>" +
    "<div class='modify_password_title'>修改密码</div>" +
       "<div class='close_modify_password_icon' onclick='closeDialog()'>X</div>" +
        "</div>" +
        "<div class='modify_password_content'>" +
        "<div class='password_style old_password'>" +
        "<label>旧密码:</label>" +
    "<div class='has_err float_left'>" +
        "<input type='password' placeholder='输入旧密码'>" +
        "<div class='err_info'></div>" +
        "</div>" +
        "</div>" +
        "<div class='password_style new_password'>" +
    "<label>新密码:</label>" +
    "<div class='has_err float_left'>" +
    "<input type='password' placeholder='输入新密码'>" +
    "<div class='err_info'></div>" +
    "</div>" +
    "</div>" +
    "<div class='password_style confirm_new_password'>" +
    "<label>确认新密码:</label>" +
    "<div class='has_err float_left'>" +
    "<input type='password' placeholder='再次输入新密码'>" +
    "<div class='err_info'></div>" +
    "</div>" +
    "</div>" +

    "<div class='confirm_modify_password button_style'>" +
    " 确定" +
    "</div>" +
    "<div class='cancel_modify_password button_style' onclick='closeDialog()'>" +
    "取消" +
    "</div>"

    $(".dialog").append(dialog);
}


