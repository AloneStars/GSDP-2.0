/**
 * Created by ViolentStone on 2016/11/16.
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

/****************数据转换******************/
//字符串装换成日期 字符串格式:2016-12-31
function stringToDate(str){
    return new Date(str);
}