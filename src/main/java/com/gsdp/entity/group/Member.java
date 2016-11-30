package com.gsdp.entity.group;

import com.gsdp.entity.user.User;

/**
 * Created by yizijun on 2016/11/28 0028.
 */
public class Member {

    private int userId;

    private int groupId;

    private String applyReason;

    private String phone;

    private int status;

    private User user;

    public Member() {}

    public Member(int userId, int groupId, String applyReason, String phone) {
        this.userId = userId;
        this.groupId = groupId;
        this.applyReason = applyReason;
        this.phone = phone;
    }

    public Member(int userId, int groupId, int status) {
        this.userId = userId;
        this.groupId = groupId;
        this.status = status;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId=" + userId +
                ", groupId=" + groupId +
                ", applyReason='" + applyReason + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
