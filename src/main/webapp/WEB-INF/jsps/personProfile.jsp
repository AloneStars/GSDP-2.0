<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人设置</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/common/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/personal.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/dialogCss.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="common/background.jsp"%>
<%@ include file="common/header.jsp"%>
<!--main-->
<div id="main">
    <div class="all_content">
        <div class="person_navigation shadow">
            <ul class="nav_ul">
                <li class="basic_info_nav">
                    <a href="javascript:;" style="color:red">基本信息</a>
                </li>
                <li class="count_info_nav">
                    <a href="javascript:;">账号信息</a>
                </li>
            </ul>
        </div>
        <div class="navigation_content shadow">
            <!--start basic information-->
            <div id="basic_info_content" class="basic_info_content nav_content">
                <div class="modify_headPicture">
                    <img src="${pageContext.request.contextPath}/${sessionScope.user.headPicture}"/>
                    <div class="change_picture modify_picture_hover">换一换</div>
                    <div class="upload_picture">
                        <a href="javascript:;" class="file">选一选
                            <form enctype="multipart/form-data" method="post">
                            <input type="file" name="headPicture" id="profile" accept="image/*">
                            </form>
                        </a>
                    </div>
                </div>
                <form action="#" method="post">
                    <div class="modify_basic_info">
                        <div class="basic_same_div">
                            <label class="basic_info_label" for="username"><strong>用户名:</strong></label>
                            <input id="username" class="name" type="text" value="${sessionScope.user.username}" name="username" placeholder="1~15位,不能有空白字符和特殊字符">
                            <div class="err-info" style="margin-left: 155px"></div>
                        </div>
                        <div class="basic_same_div">
                            <label class="basic_info_label" for="age"><strong>年龄:</strong></label>
                            <input type="text" id="age" class="age_input" value="${sessionScope.user.age}" name="age" placeholder="大于0的正整数">
                            <div class="err-info" style="margin-left: 155px"></div>
                        </div>
                        <div class="basic_same_div">
                            <label class="basic_info_label"><strong>性别:</strong></label>
                            <input type="radio" name="gender" class="gender" <c:if test="${sessionScope.user.sex == '0'}">checked</c:if> value="0">保密
                            <input type="radio" name="gender" class="gender" <c:if test="${sessionScope.user.sex == '1'}">checked</c:if> value="1">男
                            <input type="radio" name="gender" class="gender" <c:if test="${sessionScope.user.sex == '2'}">checked</c:if> value="2">女
                        </div>
                        <div class="basic_same_div">
                            <label class="basic_info_label" for="wechat"><strong>微信:</strong></label>
                            <input type="text" id="wechat" class="wechat_input" value="${sessionScope.user.weChat}" name="wechat" placeholder="请输入你的微信号">
                            <div class="err-info" style="margin-left: 155px"></div>
                        </div>
                        <div class="basic_same_div">
                            <label class="introduce_label" for="person-introduce"><strong>个性签名:</strong></label>
                            <textarea  id="person-introduce" class="person_introduce" placeholder="5~100位，不能为空白字符">${sessionScope.user.userDec}</textarea>
                            <div class="err-info" style="margin-left: 155px"></div>
                        </div>
                        <div class="basic_same_div">
                            <div class="confirm_modify" id="confirm-modify-baseInfo"><strong>确认修改</strong></div>
                        </div>
                    </div>
                </form>
            </div>
            <!--end of basic information-->
            <div id="count_info_content" class="count_info_content nav_content" style="display: none">
                <div class="bind content_basic_div">
                    <div class="bind_count"><strong>邮箱</strong> <span>1210938970@qq.com</span> <span>已绑定</span></div>
                    <div class="bind_intro">可用邮箱加密码登录，可用邮箱找回密码</div>
                    <div class="change_bind"><a href="javascript:;">更改</a></div>
                </div>
                <div class="bind content_basic_div">
                    <div class="bind_count"><strong>手机</strong> <span></span> <span>未绑定</span></div>
                    <div class="bind_intro">可用邮箱加密码登录，可用邮箱找回密码</div>
                    <div class="change_bind"><a href="javascript:;">立即绑定</a></div>
                </div>
                <div class="bind content_basic_div">
                    <div class="bind_count"><strong>密码</strong> <span>已设置</span></div>
                    <div class="bind_intro">用于保护帐号信息和登录安全</div>
                    <div class="change_bind"><a href="javascript:user.showModifyPasswordDialog();">更改</a></div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="dialog/modifyPassword.jsp"%>
<%@ include file="common/footer.jsp"%>
<!--隐藏背面-->
<div class="hideBack"></div>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/common/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/upload/ajaxfileupload.js"></script>
<script src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
<script src="${pageContext.request.contextPath}/js/request/login.js"></script>
</body>
</html>
