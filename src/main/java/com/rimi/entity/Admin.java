package com.rimi.entity;

/**
 * 管理员
 *
 * @author wjy
 * @date 2019/9/24 0024 15:50
 */
public class Admin {
    private String adminname;
    private String password;

    @Override
    public String toString() {
        return "管理员{" +
                "管理员名称='" + adminname + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}