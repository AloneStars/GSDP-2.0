/*
这是是控制所有的模态框的样式
 */
$(function () {

    //调节分辨率的时候，动态改变弹出框的位置
    $(window).resize(function () {
        var $allDialog = $(".dialog");
        for(var i = 0; i < $allDialog.length; ++i) {
            if($($allDialog[i]).css("display") === "block") {
                dialog.reModify(parseInt($($allDialog[i]).css("min-height")),
                    $($allDialog[i]).outerWidth());
                break;
            }
        }

    });

    //当我们点击关闭模态框所做的事情
    $(".dialog").on("click", "button.close, button.close-dialog", function () {
        dialog.closeDialog();
    });
});