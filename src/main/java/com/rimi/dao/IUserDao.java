package com.rimi.dao;

import com.rimi.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 14:41
 */
public interface IUserDao {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User selectByUsernameAndPassword(String username,String password);

    /**
     * 查找用户是否存在
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 查看所有用户

     * @return
     */
    List<User> selectAll();

    /**
     * 注册用户
     * @param User
     * @param pwd
     */
    public void insertUser(Map<String, String[]> User, String pwd);

    /**
     * 删除用户根据用户名
     * @param name
     */
    public void deleteUser(String name);

    /**
     * 修改用户
     * @param user
     * @param
     * @param password
     */
    public void updateUser(User user,String password);
}
