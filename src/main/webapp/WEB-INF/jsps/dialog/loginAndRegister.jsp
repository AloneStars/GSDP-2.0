<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!--生成登录和注册的dialog-->
<div class="dialog dialog-shadow" id="login-register-dialog">
    <div class="modal-content login-register-dialog-size">
        <div class="modal-header" style="padding:0">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="padding: 10px; margin: 0px">
                ×
            </button>
            <h4 class="modal-title" id="login-register-modal">
                <ul class="nav nav-tabs" style="border-bottom-width: 0px;">
                    <li class="active" style="width: 70px">
                        <a href="#login-navigation" data-toggle="tab" style="height: 43px; width:68px">登录</a>
                    </li>
                    <li style="width: 70px">
                        <a href="#register-navigation" data-toggle="tab" style="height: 43px; width: 68px;">注册</a>
                    </li>
                </ul>
            </h4>
        </div>
        <div class="tab-content">
            <!--登录模态框-->
            <div class="tab-pane active" id="login-navigation">
                <form method="post" class="form-horizontal" role="form" id="login-form">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="login-email" class="col-sm-3 control-label">
                                        邮箱:
                                    </label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="email" id="login-email"
                                               placeholder="email"/>
                                        <div class="err-info"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="login-password" class="col-sm-3 control-label">
                                        密码:
                                    </label>
                                    <div class="col-sm-7">
                                        <input type="password" class="form-control" name="password" id="login-password"
                                               placeholder="email"/>
                                        <div class="err-info"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end of body-->
                    </div>
                    <div class="modal-footer">
                        <div class="row">
                            <button type="button" class="btn btn-primary col-sm-8 col-sm-offset-2">
                                登录
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <!--登录模态框结束-->
            <!--注册模态框-->
            <div class="tab-pane" id="register-navigation">
                <form method="post" class="form-horizontal" role="form" id="register-form">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="register-email" class="col-sm-3 control-label">
                                        邮箱:
                                    </label>
                                    <div class="col-sm-7">
                                        <input type="email" class="form-control" name="email" id="register-email"
                                               placeholder="email"/>
                                        <div class="err-info"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="register-password" class="col-sm-3 control-label">
                                        密码:
                                    </label>
                                    <div class="col-sm-7">
                                        <input type="password" class="form-control" name="password"
                                               id="register-password" placeholder="email"/>
                                        <div class="err-info"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="confirm-password" class="col-sm-3 control-label">
                                        确认密码:
                                    </label>
                                    <div class="col-sm-7">
                                        <input type="password" class="form-control" name="password"
                                               id="confirm-password" placeholder="email"/>
                                        <div class="err-info"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="captcher" class="col-sm-3 control-label">
                                        验证码:
                                    </label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="captcher" placeholder="captcher">
                                        <div class="err-info"></div>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-primary">发送邮件</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end of body-->
                    </div>
                    <div class="modal-footer">
                        <div class="row">
                            <button type="button" class="btn btn-primary col-sm-8 col-sm-offset-2">
                                注册
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <!--注册模态框结束-->
        </div>
    </div>
</div>
<!--登录dialog结束-->