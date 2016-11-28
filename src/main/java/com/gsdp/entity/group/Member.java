package com.gsdp.entity.group;

/**
 * Created by yizijun on 2016/11/28 0028.
 */
public class Member {

    private int userId;

    private int groupId;

    private String applyReason;

    private String phone;

    private int status;

    public Member() {}

    public Member(int userId, int groupId, String applyReason, String phone) {
        this.userId = userId;
        this.groupId = groupId;
        this.applyReason = applyReason;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId=" + userId +
                ", groupId=" + groupId +
                ", applyReason='" + applyReason + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
