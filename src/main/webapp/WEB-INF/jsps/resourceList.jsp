<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>资源总库</title>
    <%@include file="common/style.jsp"%>
    <link href="${pageContext.request.contextPath}/css/video-js.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/video.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/resourceList.js"></script>
    <link href="${pageContext.request.contextPath}/css/resourceList.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/common/myDialog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dialogCss.css" rel="stylesheet">
</head>
<body>
<jsp:include page="common/background.jsp"/>
<div id="container">
    <jsp:include page="common/header.jsp"/>
    <!-- 内容版块 -->
    <div id="content-container">

        <div id="group_lobby">
            <div class="left shadow">
                <ul>
                    <li><div class="type">
                        <span class="type_name"><b>视频区/Video</b></span>
                        <div class="typeIcon shadow video"></div>
                    </div></li>
                    <li><div class="type">
                        <span class="type_name"><b>音频区/Audio</b></span>
                        <div class="typeIcon shadow audio"></div>
                    </div></li>
                    <li><div class="type">
                        <span class="type_name"><b>文档区/Text</b></span>
                        <div class="typeIcon shadow text"></div>
                    </div></li>
                    <li><div class="type">
                        <span class="type_name"><b>图片区/Picture</b></span>
                        <div class="typeIcon shadow picture"></div>
                    </div></li>
                    <li><div class="type">
                        <span class="type_name"><b>软件区/Soft</b></span>
                        <div class="typeIcon shadow soft"></div>
                    </div></li>
                </ul>
            </div>

            <div class="right shadow">
                <div id="video" class="box">
                    <div class="banner_box">
                        <div class="resource_banner">
                            <span class="dec"><b><i>视屏展映</i></b></span><span class="more"><b>+</b></span>
                        </div>
                    </div>
                    <div class="videoList">
                        <ul>
                            <li class="begin"><a href="javascript:;"
                                                 onclick="begin('${pageContext.request.contextPath}/file/video/star.mp4');">star</a></li>
                            <li class="begin"><a href="javascript:;"
                                                 onclick="begin('${pageContext.request.contextPath}/file/video/car.mp4');">car</a></li>
                        </ul>
                    </div>
                    <div class="player">
                        <!-- <video src="file/video/star.mp4" controls="controls">
                            your browser does not support the video tag
                      </video> -->
                        <video id="video"
                               class="video-js vjs-default-skin vjs-big-play-centered" controls
                               preload="auto" width="668px" height="374px" poster=""
                               data-setup="{}">
                            <source src="" type='video/mp4' />
                            <source src="" type='video/webm' />
                            <source src="" type='video/ogg' />
                            <track kind="captions" src="demo.captions.vtt" srclang="en"
                                   label="English"></track>
                            <!-- Tracks need an ending tag thanks to IE9 -->
                            <track kind="subtitles" src="demo.captions.vtt" srclang="en"
                                   label="English"></track>
                            <!-- Tracks need an ending tag thanks to IE9 -->
                        </video>
                    </div>
                    <div class="video_intro">
                        <div class="video_intro_left">
                            <div class="videoIcon"></div>
                            <div class="videoMsg">
                                <div class="title">
                                    <b><i>星空拍摄视频</i></b>
                                </div>
                                <div class="updater">
                                    上传者：<i>耀光下的孤星</i>
                                </div>
                                <div class="updateTime">
                                    上传时间：<i>2016/2/21</i>
                                </div>
                            </div>
                        </div>
                        <div class="video_intro_right">
                            <span class="intro"><b>简介：</b><i>星空摄影团队呕心沥血制作，全团体彻夜不眠的结果...</i></span>

                        </div>
                    </div>
                </div>
                <div id="audio" class="box">
                    <div class="audioContent">
                        <div class="audio_box">
                            <audio id="myAudio" src="${pageContext.request.contextPath}/file/music/HITA-cry.mp3">
                                <h1>你的浏览器OUT了！</h1>
                            </audio>
                            <div id="music">
                                <img class="mcd" src="${pageContext.request.contextPath}/image/music/hita.jpg">
                                <div id="play_pause"></div>
                            </div>
                            <div class="audio_icon">
                                <ul>
                                    <li class="like"><div>喜欢</div></li>
                                    <li class="hate"><div>拍砖</div></li>
                                    <li class="download"><div>下载</div></li>
                                </ul>
                            </div>
                        </div>
                        <div class="audio_intro">
                            <div class="audio_intro_msg">
                                <span class="AudioName">AudioName:HITA-花神泪</span> <span
                                    class="Publish"><i class="Publisher">上传者：耀光下的孤星</i><i
                                    class="PublishTime">上传时间：2016/8/23</i></span> <span
                                    class="AudioDetail">简介：歌曲《花神泪》来自于GAME2开发的游戏《仙域》，演唱者是L.A。翻唱：HITA、小爱的妈、清莞、引月兮、奇然、流月、玄觞、漠然、董贞等。</span>
                            </div>
                        </div>
                    </div>
                    <div class="audioList">
                        <div class="MostNew">
                            <span class="audioList_title"><b>最新音频</b></span>
                            <ul>
                                <li><a href="javascript:play('dfp.mp3','zjl.jpg');">东风破.mp3</a></li>
                                <li>双节棍.mp4</li>
                                <li>菊花台.mp4</li>
                                <li>红尘客栈.mp4</li>
                            </ul>
                        </div>
                        <div class="MostLike">
                            <span class="audioList_title"><b>最热音频</b></span>
                            <ul>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                            </ul>
                        </div>
                        <div class="MostDownload">
                            <span class="audioList_title"><b>最多下载</b></span>
                            <ul>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                            </ul>
                        </div>
                    </div>

                </div>
                <div id="text" class="box">text</div>
                <div id="picture" class="box">picture</div>
                <div id="soft" class="box">soft</div>
            </div>
        </div>

    </div>
    <!-- 页脚 -->
    <jsp:include page="common/footer.jsp"/>
</div>
<!--加入隐藏背面-->
<div class="hideBack"></div>
<script src="${pageContext.request.contextPath}/js/common/myDialog.js"></script>
<script src="${pageContext.request.contextPath}/js/dialogJs.js"></script>
<script src="${pageContext.request.contextPath}/js/request/user.js"></script>
</body>
</html>

