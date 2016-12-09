<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--modifyGroupInfo dialog开始-->
<div class="dialog dialog-shadow" id="modify-group-info-dialog">
    <div class="modal-content modify-group-info-size">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title" id="modify-group-info-modal">
                <strong>修改团队信息</strong>
            </h4>
        </div>
        <form method="post" class="form-horizontal" role="form" id="modify-group-info-form">
            <div class="modal-body">

                <div class="form-group">
                    <div class="modify-group-icon">
                    <img src="${pageContext.request.contextPath}/${group.groupIcon}"/>
                    <div class="change-picture modify-picture-hover">换一换</div>
                    <div class="upload-picture">
                        <a href="javascript:;" class="group-icon-file">选一选
                            <form enctype="multipart/form-data" method="post">
                                <input type="file" name="groupIcon" id="groupIcon" accept="image/*">
                            </form>
                        </a>
                    </div>
                </div>
                    </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="modify-group-name">
                        团队名称:
                    </label>
                    <div class="col-sm-7">
                       <input type="text" class="form-control" name="groupName" id="modify-group-name" placeholder=
                               "1~10位,非数字,非空白字符" value="${group.groupName}">
                        <div class="err-info"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="modify-group-contact" class="col-sm-3 control-label">
                        联系方式:
                    </label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="groupContact" id="modify-group-contact"
                               placeholder="请输入正确的手机号码" value="${group.groupContact}"/>
                        <div class="err-info"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="modify-group-address" class="col-sm-3 control-label">
                        办公地点:
                    </label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="groupAddress" id="modify-group-address"
                               placeholder="5-25位之间" value="${group.groupAddress}"/>
                        <div class="err-info"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="modify-group-type" class="col-sm-3 control-label">
                        团队类型:
                    </label>
                    <div class="col-sm-7">

                        <select id="modify-group-type" class="form-control" name="groupType">
                            <option <c:if test="${group.groupType eq 1}">selected</c:if> value="1">艺术类</option>
                            <option <c:if test="${group.groupType eq 2}">selected</c:if> value="2">公益类</option>
                            <option <c:if test="${group.groupType eq 3}">selected</c:if> value="3">文化类</option>
                            <option <c:if test="${group.groupType eq 4}">selected</c:if> value="4">科创类</option>
                            <option <c:if test="${group.groupType eq 5}">selected</c:if> value="5">体育类</option>
                            <option <c:if test="${group.groupType eq 6}">selected</c:if> value="6">素拓类</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="modify-group-introduce">
                        团队介绍:
                    </label>
                    <div class="col-sm-7">
                                <textarea name="groupDec" id="modify-group-introduce" class="no-resize form-control" rows="4"
                                          placeholder="例如:我们团队是一支摄影团队...">${group.groupDec}</textarea>
                        <div class="err-info"></div>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <div class="row text-center">
                    <button type="button" class="btn btn-primary">
                        确定
                    </button>
                    <button type="button" class="btn btn-default close-dialog" data-dismiss="modal">
                        取消
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!--modifyGroupInfo dialog结束-->