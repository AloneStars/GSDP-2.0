<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人设置</title>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/personal.css" type="text/css" rel="stylesheet">

    <style type="text/css">
        .file {
            display:inline-block;
            width:100%;
            height:100%;
            position:relative;
            overflow:hidden;
            text-align: center;
        }

        .file input {
            position:absolute;
            right:0;
            top:0;
            font-size:100px;
            opacity:0;
        }

        .file:hover {
            background: #6cf;
            border-color: #78C3F3;
            color: #004974;
        }
    </style>
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
                    <img src="${sessionScope.user.headPicture}"/>
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
                            <input id="username" class="name" type="text" value="${sessionScope.user.username}" name="username">
                        </div>
                        <div class="basic_same_div">
                            <label class="basic_info_label" for="age"><strong>年龄:</strong></label>
                            <input type="text" id="age" class="age_input" value="${sessionScope.user.age}" name="age">
                        </div>

                        <div class="basic_same_div">
                            <label class="basic_info_label"><strong>性别:</strong></label>
                            <input type="radio" name="gender" class="gender" <c:if test="${sessionScope.user.sex == '0'}">checked</c:if> value="0">保密
                            <input type="radio" name="gender" class="gender" <c:if test="${sessionScope.user.sex == '1'}">checked</c:if> value="1">男
                            <input type="radio" name="gender" class="gender" <c:if test="${sessionScope.user.sex == '2'}">checked</c:if> value="2">女
                        </div>

                        <div class="basic_same_div">
                            <label class="basic_info_label"><strong>微信:</strong></label>
                            <input type="text" id="wechat" class="wechat_input" value="${sessionScope.user.weChat}" name="wechat">
                        </div>

                        <div class="basic_same_div">
                            <label class="introduce_label"><strong>个性签名:</strong></label>
                            <textarea  class="person_introduce">${sessionScope.user.userDec}</textarea>
                        </div>

                        <div class="basic_same_div">
                            <div class="confirm_modify"><strong>确认修改</strong></div>
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
                    <div class="change_bind"><a href="javascript:;">更改</a></div>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<!--隐藏背面-->
<div class="hidebg"></div>


<%@ include file="common/footer.jsp"%>


<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/upload/ajaxfileupload.js"></script>
<script src="${pageContext.request.contextPath}/js/user.js"></script>
</body>
</html>
