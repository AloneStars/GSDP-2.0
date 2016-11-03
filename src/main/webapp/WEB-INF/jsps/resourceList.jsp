<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!doctype html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>资源列表</title>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="/GSDP/css/video-js.min.css" rel="stylesheet">
    <link href="/GSDP/css/resourceList.css" type="text/css" rel="stylesheet">
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

        <div id="group_lobby">
            <div class="left shadow">
                <ul>
                    <li><div class="type video">
                        <span class="type_name"><b>视频区/Video</b></span>
                        <div class="typeIcon shadow"></div>
                    </div></li>
                    <li><div class="type audio">
                        <span class="type_name"><b>音频区/Audio</b></span>
                        <div class="typeIcon shadow"></div>
                    </div></li>
                    <li><div class="type text">
                        <span class="type_name"><b>文档区/Text</b></span>
                        <div class="typeIcon shadow"></div>
                    </div></li>
                    <li><div class="type picture">
                        <span class="type_name"><b>图片区/Picture</b></span>
                        <div class="typeIcon shadow"></div>
                    </div></li>
                    <li><div class="type soft">
                        <span class="type_name"><b>软件区/Soft</b></span>
                        <div class="typeIcon shadow"></div>
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
                                                 onclick="begin('file/video/star.mp4');">star</a></li>
                            <li class="begin"><a href="javascript:;"
                                                 onclick="begin('file/video/car.mp4');">car</a></li>
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
                            <audio id="myAudio" src="file/music/HITA-cry.mp3">
                                <h1>你的浏览器OUT了！</h1>
                            </audio>
                            <div id="music">
                                <img class="mcd" src="image/music/hita.jpg">
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
                            <span class="audioList_title"><b>最新音频</b></span>
                            <ul>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                                <li>123.mp4</li>
                            </ul>
                        </div>
                        <div class="MostDownload">
                            <span class="audioList_title"><b>最新音频</b></span>
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
    <%@ include file="common/footer.jsp"%>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script src="/GSDP/js/video.min.js"></script>
    <script src="/GSDP/js/common.js"></script>
    <script src="/GSDP/js/resourceList.js"></script>
</div>
</body>
</html>
