<%@ page contentType="text/html; charset=utf-8" language="java" %>
<div class="dialog dialog-shadow" id="modify-password-dialog">
    <div class="modal-content modify-password-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title">
                <b>修改密码</b>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="modify-password-form">
            <!--start body-->
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="old-password" class="col-sm-4 control-label">
                                原密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="oldPassword" id="old-password"
                                       placeholder="6-16位密码, 区分大小写, 非空白字符"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="new-password" class="col-sm-4 control-label">
                                新密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="new-password" name="newPassword"
                                       placeholder="6-16位密码, 区分大小写, 非空白字符"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirm-password" class="col-sm-4 control-label">
                                确认密码:
                            </label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="confirm-password" name="confirmPassword"
                                       placeholder="6-16位密码, 区分大小写, 非空白字符"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--end of body-->
            <div class="modal-footer">
                <div class="row">
                    <button type="button" class="btn btn-primary col-sm-2 col-sm-offset-4" id="modify">
                        修改
                    </button>
                    <button type="button" class="btn btn-default col-sm-2" data-dismiss="modal">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
