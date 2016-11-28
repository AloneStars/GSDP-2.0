package com.gsdp.dto.group;

import com.gsdp.entity.group.Member;

/**增加社团社员的时候的dto，因为我们要给管理员发一封消息，这个消息应该包含
 * 哪个用户申请加入了哪个社团，以及申请的相关消息
 * Created by yizijun on 2016/11/28 0028.
 */
public class MemberAddition {

    private boolean success;

    private String username;

    private String groupName;

    private Member member;

    public MemberAddition() {}

    public MemberAddition(boolean success, String username, String groupName, Member member) {
        this.success = success;
        this.username = username;
        this.groupName = groupName;
        this.member = member;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "MemberAddition{" +
                "success=" + success +
                ", username='" + username + '\'' +
                ", groupName='" + groupName + '\'' +
                ", member=" + member +
                '}';
    }
}
