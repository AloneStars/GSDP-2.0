/**
 * Created by ViolentStone on 2016/11/16.
 */


/**
 验证数字的正则表达式集
 验证数字：^[0-9]*$
 验证n位的数字：^\d{n}$
 验证至少n位数字：^\d{n,}$
 验证m-n位的数字：^\d{m,n}$
 验证零和非零开头的数字：^(0|[1-9][0-9]*)$
 验证有两位小数的正实数：^[0-9]+(.[0-9]{2})?$
 验证有1-3位小数的正实数：^[0-9]+(.[0-9]{1,3})?$
 验证非零的正整数：^\+?[1-9][0-9]*$
 验证非零的负整数：^\-[1-9][0-9]*$
 验证非负整数（正整数 + 0） ^\d+$
 验证非正整数（负整数 + 0） ^((-\d+)|(0+))$
 验证长度为3的字符：^.{3}$
 验证由26个英文字母组成的字符串：^[A-Za-z]+$
 验证由26个大写英文字母组成的字符串：^[A-Z]+$
 验证由26个小写英文字母组成的字符串：^[a-z]+$
 验证由数字和26个英文字母组成的字符串：^[A-Za-z0-9]+$
 验证由数字、26个英文字母或者下划线组成的字符串：^\w+$
 验证用户密码:^[a-zA-Z]\w{5,17}$ 正确格式为：以字母开头，长度在6-18之间，只能包含字符、数字和下划线。
 验证是否含有 ^%&',;=?$\" 等字符：[^%&',;=?$\x22]+
 验证汉字：^[\u4e00-\u9fa5],{0,}$
 验证Email地址：^\w+[-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
 验证InternetURL：^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$ ；^[a-zA-z]+://(w+(-w+)*)(.(w+(-w+)*))*(?S*)?$
 验证电话号码：^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$：--正确格式为：XXXX-XXXXXXX，XXXX-XXXXXXXX，XXX-XXXXXXX，XXX-XXXXXXXX，XXXXXXX，XXXXXXXX。
 验证身份证号（15位或18位数字）：^\d{15}|\d{}18$
 验证一年的12个月：^(0?[1-9]|1[0-2])$ 正确格式为：“01”-“09”和“1”“12”
 验证一个月的31天：^((0?[1-9])|((1|2)[0-9])|30|31)$ 正确格式为：01、09和1、31。
 整数：^-?\d+$
 非负浮点数（正浮点数 + 0）：^\d+(\.\d+)?$
 正浮点数 ^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$
 非正浮点数（负浮点数 + 0） ^((-\d+(\.\d+)?)|(0+(\.0+)?))$
 负浮点数 ^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$
 浮点数 ^(-?\d+)(\.\d+)?$
 */

/****************数据转译******************/
//去掉html标签
function removeHtmlTab(tab) {
    return tab.replace(/<[^<>]+?>/g,'');//删除所有HTML标签
}

//普通字符转换成转意符
function html2Escape(sHtml) {
    return sHtml.replace(/[<>&"]/g,function(c){return {'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;'}[c];});
}

//转意符换成普通字符
function escape2Html(str) {
    var arrEntities={'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'};
    return str.replace(/&(lt|gt|nbsp|amp|quot);/ig,function(all,t){return arrEntities[t];});
}

// &nbsp;转成空格
function nbsp2Space(str) {
    var arrEntities = {'nbsp' : ' '};
    return str.replace(/&(nbsp);/ig, function(all, t){return arrEntities[t]})
}

//回车转为br标签
function return2Br(str) {
    return str.replace(/\r?\n/g,"<br />");
}

//去除开头结尾换行,并将连续3次以上换行转换成2次换行
function trimBr(str) {
    str=str.replace(/((\s|&nbsp;)*\r?\n){3,}/g,"\r\n\r\n");//限制最多2次换行
    str=str.replace(/^((\s|&nbsp;)*\r?\n)+/g,'');//清除开头换行
    str=str.replace(/((\s|&nbsp;)*\r?\n)+$/g,'');//清除结尾换行
    return str;
}

// 将多个连续空格合并成一个空格
function mergeSpace(str) {
    str=str.replace(/(\s|&nbsp;)+/g,' ');
    return str;
}

/********************格式控制********************/
//去掉字符串中的所有空格
function Trim(str,is_global)
{
    var result;
    result = str.replace(/(^\s+)|(\s+$)/g,"");
    if(is_global.toLowerCase()=="g")
    {
        result = result.replace(/\s/g,"");
    }
    return result;
}


/*****************数据判断******************/
//判断字符串是否为undefine,是的话返回 true;
function isUndefine(str){
    return typeof(str)=="undefined";
}

//判断字符串的长度是否满足长度
function checkLength(str,start,end){
    if(str.length >= start && str.length <= end)
        return true;
    else
        return false;
}
//判断邮箱格式是否正确
function checkMail(mail) {
    var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(mail))
        return true;
    else
        return false;
}

//验证输入的为6位长度的数字
function verifyNumber(str){
    var reg = new RegExp(/^\d{6}$/);
    return reg.test(str);
}

/****************数据转换******************/
//字符串装换成日期 字符串格式:2016-12-31
function stringToDate(str){
    return new Date(str);
}