<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!--生成所有的dialog-->
<div class="dialog shadow" id="login-dialog">
    <form method="post" class="form-horizontal" role="form" id="login-form">
        <div class="modal-content login-dialog-size">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="login-modal">
                    <b>登录</b>
                </h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">
                                邮箱:
                            </label>
                            <div class="col-sm-7">
                                <input type="email" class="form-control" name="email" id="email" placeholder="email"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">
                                密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="password" id="password" placeholder="email"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="captcher" class="col-sm-3 control-label">
                                验证码:
                            </label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="captcher" placeholder="captcher">
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
                        登录
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<!--dialog结束-->
