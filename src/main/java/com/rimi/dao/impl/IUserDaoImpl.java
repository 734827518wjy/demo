package com.rimi.dao.impl;

import com.rimi.dao.IUserDao;
import com.rimi.entity.User;
import com.rimi.util.JDBCUtils;
import com.rimi.util.PWDUtils;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:27
 */
public class IUserDaoImpl implements IUserDao {
    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        //定义sql语句
        String sql = "select * from user where username = ? and password = ?";
        //执行sql
        return JDBCUtils.executeQueryForOne(User.class,sql,username,password);
    }

    @Override
    public User selectByUsername(String username){
        String sql = "select * from user where username = ?";
        return JDBCUtils.executeQueryForOne(User.class,sql,username);
    }

    @Override
    public List<User> selectAll(){
        String sql = "select * from user";
        return JDBCUtils.executeQuery(User.class,sql);
    }

    /**
     * 添加用户
     * @param user
     * @param pwd
     */
    @Override
    public void insertUser(Map<String, String[]> user, String pwd) {
        //定义sql语句
        String sql = "insert into user(username,password) values(?,?)";
        String pwd1 = PWDUtils.getPwd(pwd);
        JDBCUtils.executeUpdate(sql,user.get("registeredName")[0],pwd1);
    }

    @Override
    public void deleteUser(String name) {
        //定义sql
        String sql = "delete from user where username like ?";
        JDBCUtils.executeUpdate(sql,name);
    }

    @Override
    public void updateUser(User user,String password) {
        //定义sql
        String sql = "update users.user set password = ? where username = ?";
        JDBCUtils.executeUpdate(sql,password,user.getUsername());
    }
}
