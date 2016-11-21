<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!--create-situation-dialog开始-->
<div class="dialog dialog-shadow" id="create-situation-dialog">
    <div class="modal-content create-situation-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title" id="situation-modal">
                <strong>发布动态</strong>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="create-situation-form">
            <div class="modal-body" style="padding: 0px">
                <!-- start row1-->
                <div class="form-group" style="margin: 7px auto">
                    <label for="situation-name" class="col-sm-2 col-sm-offset-2 control-label">
                        动态名称:
                    </label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="situationName" id="situation-name" placeholder="例如:今天我们有一组非常漂亮的照片"/>
                        <div class="err-info"></div>
                    </div>
                </div>
                <!-- end of row1-->
                <!--start row2-->
                <div class="form-group" style="margin: 0px; padding: 0px">
                    <!-- 加载编辑器的容器 -->
                    <script id="situation-container" name="situationContent" type="text/plain">
                            动态主题
                        </script>
                </div>
                <!--end of row2-->
            </div>
            <div class="modal-footer">
                <div class="row text-center">
                    <button type="button" class="btn btn-success" data-dismiss="modal">
                        发布
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--create-situation-dialog结束-->
