package com.gsdp.dto.group;

import com.gsdp.entity.Role;

/**
 * 这个dto是封装当前用户在团队中的角色和当前社团的所有成员信息（包括成员的详细信息，但是
 * 把用户的密码给抹去了，并且包括该用户在这个团队中的角色）
 * Created by yizijun on 2016/12/1 0001.
 */
public class GroupMemberWithCurrentUserRole {

    private Role currentRole;

    private GroupMember groupMember;

    public GroupMemberWithCurrentUserRole() {}

    public GroupMemberWithCurrentUserRole(Role currentRole, GroupMember groupMember) {
        this.currentRole = currentRole;
        this.groupMember = groupMember;
    }

    public Role getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(Role currentRole) {
        this.currentRole = currentRole;
    }

    public GroupMember getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(GroupMember groupMember) {
        this.groupMember = groupMember;
    }

    @Override
    public String toString() {
        return "GroupMemberWithCurrentUserRole{" +
                "currentRole=" + currentRole +
                ", groupMember=" + groupMember +
                '}';
    }
}
