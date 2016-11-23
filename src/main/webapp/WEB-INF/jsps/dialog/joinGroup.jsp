<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!--joinGroup dialog开始-->
<div class="dialog dialog-shadow" id="join-group-dialog">
    <div class="modal-content join-group-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title" id="join-group-modal">
                <strong>加入组织</strong>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="join-group-form">
            <div class="modal-body">
                <div class="form-group">
                    <label for="apply-group-contact" class="col-sm-4 control-label">
                        手机号码:
                    </label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="contact" id="apply-group-contact"
                               placeholder="例如:13811111111"/>
                        <div class="err-info"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="apply-reason">
                        申请理由:
                    </label>
                    <div class="col-sm-7">
                        <textarea name="apply-reason" id="apply-reason" class="no-resize form-control" rows="5"
                                  placeholder="例如:我能够在这个社团学到很多的东西"></textarea>
                        <div class="err-info"></div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="row text-center">
                    <button type="button" class="btn btn-primary">
                        确定
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="dialog.closeDialog();">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--joinGroup dialog结束-->


