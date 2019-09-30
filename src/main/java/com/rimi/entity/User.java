package com.rimi.entity;

/**
 * @author wjy
 * @date 2019/9/23 0023 17:35
 */
public class User {
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "用户{" +
                "用户名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
