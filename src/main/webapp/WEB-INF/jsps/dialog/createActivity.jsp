<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!--create-activity-dialog开始-->
    <div class="dialog dialog-shadow" id="create-activity-dialog">
        <div class="modal-content create-activity-size">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="activity-modal">
                    <strong>发布活动</strong>
                </h4>
            </div>
            <form method="post" class="form-horizontal" role="form" id="create-activity-form">
                <div class="modal-body">
                    <!-- start row1-->
                    <div class="form-group">
                        <label for="activity-name" class="col-sm-2 control-label">
                            活动名称:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="activityName" id="activity-name"
                                   placeholder="例如:ACM竞赛" autocomplete="off"/>
                            <div class="err-info"></div>
                        </div>
                        <label for="open" class="col-sm-2 control-label">
                            对外开放:
                        </label>
                        <div class="col-sm-4">
                            <select id="open" name="open" class="form-control">
                                <option value="1" selected>是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <!-- end of row1-->
                    <!-- start row2-->
                    <div class="form-group">
                        <label for="start-time" class="col-sm-2 control-label">
                            开始时间:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control laydate-icon set-height" name="startTime" id="start-time"
                                   placeholder="yyyy-mm-dd" autocomplete="off"/>
                            <div class="err-info"></div>
                        </div>
                        <label for="end-time" class="col-sm-2 control-label">
                            结束时间:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control laydate-icon set-height" name="endTime" id="end-time"
                                   placeholder="yyyy-mm-dd" autocomplete="off"/>
                            <div class="err-info"></div>
                        </div>
                    </div>
                    <!-- end of row2-->
                    <!-- start row3-->
                    <div class="form-group">
                        <label for="activity-member" class="col-sm-2 control-label">
                            活动人数:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="activityMember" id="activity-member"
                                   placeholder="例如:200" autocomplete="off"/>
                            <div class="err-info"></div>
                        </div>
                        <label for="location" class="col-sm-2 control-label">
                            活动地点:
                        </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="location" id="location" placeholder="例如:A7-310" autocomplete="off"/>
                            <div class="err-info"></div>
                        </div>
                    </div>
                    <!-- end of row3-->
                    <!--start row4-->
                    <div class="form-group" style="margin: 0px; padding: 0px; display: none;">
                        <script id="activity-container" name="activityContent" type="text/plain">请在这里键入你的发表活动的内容...</script>
                    </div>
                    <!--end of row4-->
                </div>
                <div class="modal-footer">
                    <div class="row text-center">
                        <button type="button" id="next-step" class="btn btn-primary">
                            下一步
                        </button>
                        <button type="button" class="btn btn-default close-dialog" data-dismiss="modal">
                            取消
                        </button>
                        <button type="button" id="last-step" class="btn btn-primary" style="display: none">
                            上一步
                        </button>
                        <button type="button" id="activity-submit" class="btn btn-success" data-dismiss="modal" style="display: none">
                            提交
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--dialog结束-->
