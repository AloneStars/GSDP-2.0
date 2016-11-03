<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>活动列表</title>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="/GSDP/css/activityList.css" type="text/css" rel="stylesheet">
    <link href="/GSDP/css/common.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="background">
    <div class="bg1 "></div>
    <div class="bg2 "></div>
    <div class="bg3 "></div>
    <div class="bg4 "></div>
    <div class="bg5 "></div>
</div>
<div id="container">
    <!-- 页眉 -->
    <%@ include file="common/header.jsp"%>
    <!-- 内容版块 -->
    <div id="content-container">
        <div class="left shadow">
            <div class="activity_banner">
                <b><i>活动走廊</i></b>
            </div>
            <div class="left_content">
                <ul id="AllActivity">

                </ul>
            </div>


        </div>

        <div class="right">

            <div class="right_top shadow">
                <div class="activity_banner">
                    <b><i>最新活动</i></b>
                </div>
                <div class="right_top_content">
                    <ul>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                    </ul>
                </div>

            </div>

            <div class="right_bottom shadow">
                <div class="activity_banner">
                    <b><i>最热活动</i></b>
                </div>
                <div class="right_bottom_content">
                    <ul>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                        <li><nobr>
                            <a href="#"><span class='title'>11111111111111111</span></a>
                        </nobr></li>
                    </ul>
                </div>
            </div>

        </div>

    </div>
    <!-- 页脚 -->
    <%@ include file="common/footer.jsp"%>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="/GSDP/js/common.js"></script>
    <script src="/GSDP/js/activityList.js"></script>
</div>
</body>
</html>

