package com.common.utils;

/**
 * @author Bandit
 * @createTime 2022/6/14 15:17
 */
public enum RoleEnum {
    //管理员
    ADMIN("admin"),
    //普通用户
    USER("user");
    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
