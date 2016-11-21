<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!--生成所有的dialog-->
<div class="dialog dialog-shadow" id="create-group-dialog">
    <div class="modal-content create-group-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title" id="group-modal">
                <strong>创建团队</strong>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="group-creation-form"
              enctype="multipart/form-data">
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <!--start row1-->
                        <div class="form-group">
                            <label for="group_name" class="col-sm-4 control-label">
                                团队名称:
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="groupName" id="group_name"
                                       placeholder="例如:星空摄影团队"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <!--end of row1-->
                        <!--start row2-->
                        <div class="form-group">
                            <label for="contact" class="col-sm-4 control-label">
                                联系方式(电话):
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="contact"
                                       name="groupContact" placeholder="例如:13811111111"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <!--end of row2-->
                        <!--start row3-->
                        <div class="form-group">
                            <label for="work_address" class="col-sm-4 control-label">
                                办公地点:
                            </label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="work_address"
                                       name="groupAddress" placeholder="例如:A7-310"/>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <!--end of row3-->
                        <!--start row4-->
                        <div class="form-group">
                            <label for="group_type" class="col-sm-4 control-label">
                                团队类型:
                            </label>
                            <div class="col-sm-7">
                                <select id="group_type" class="form-control" name="groupType">
                                    <option selected value="1">艺术类</option>
                                    <option value="2">公益类</option>
                                    <option value="3">文化类</option>
                                    <option value="4">科创类</option>
                                    <option value="5">体育类</option>
                                    <option value="6">素拓类</option>
                                </select>
                            </div>
                        </div>
                        <!--end of row4-->
                        <!--start row5-->
                        <div class="form-group">
                            <label for="profile" class="col-sm-4 control-label">
                                佐证材料:
                            </label>
                            <div class="col-sm-7">
                                <a href="javascript:;" class="file form-control">选择文件
                                    <input type="file" name="checkFile" id="profile"
                                           accept="image/jpeg,image/jpg,application/msword">
                                </a>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <!--end of row5-->
                        <!--start row6-->
                        <div class="form-group">
                            <label class="col-sm-4 control-label">
                                团队介绍:
                            </label>
                            <div class="col-sm-7">
                                <textarea name="groupDec" id="group_introduce" class="no-resize form-control" rows="5"
                                          placeholder="例如:我们团队是一支摄影团队..."></textarea>
                                <div class="err-info"></div>
                            </div>
                        </div>
                        <!--end of row6-->
                        <div class="text-center text-red">
                            注意:佐证材料的格式必须是jpg,jpeg,doc.大小不超过5m
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="row">
                    <button type="button" class="btn btn-primary col-sm-2 col-sm-offset-4" id="submit-apply-group">
                        确定
                    </button>
                    <button type="button" class="btn btn-default col-sm-2" data-dismiss="modal">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--dialog结束-->


