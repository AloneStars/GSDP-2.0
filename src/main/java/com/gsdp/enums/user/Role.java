package com.gsdp.enums.user;

/**
 * Created by yizijun on 2016/12/1 0001.
 */
public enum Role {

    ORDINARY_USER(1, "普通用户"),
    GROUP_USER(2, "团队成员"),
    GROUP_ADMIN(3, "团队管理员"),
    GROUP_OWNER(4, "团队法人")
    ;

    private int roleId;

    private String roleName;

    private Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static Role getRole(int roleId) {
        for(Role role : values()) {
            if(roleId == role.getRoleId()) {
                return role;
            }
        }
        return null;
    }
}
