package com.rimi.dao.impl;

import com.rimi.dao.IAdminDao;
import com.rimi.entity.Admin;
import com.rimi.util.JDBCUtils;

import java.util.List;

/**
 * @author wjy
 * @date 2019/9/25 0025 16:22
 */
public class AdminDaoImpl implements IAdminDao {
    /**
     * 查看所有管理员
     *
     * @param admin
     */
    @Override
    public List<Admin> selectAll(Admin admin) {
        //定义sql语句
        String sql = "select * from admin";
        return JDBCUtils.executeQuery(Admin.class,sql);
    }

    /**
     * 根据用户名和密码查询管理员
     * @param adminName
     * @param password
     */
    @Override
    public Admin selectByAdminNameAndPassword(String adminName, String password){
        String sql = "select * from admin where adminname = ? and password = ?";
        return JDBCUtils.executeQueryForOne(Admin.class,sql,adminName,password);
    }

    /**
     * 修改管理员名称或者密码
     *
     * @param adminname
     * @param password
     */
    @Override
    public void updateAdmin(Admin admin, String adminname, String password) {
        String sql = "update admin set adminname = ?,password = ? where adminname = ?,password = ?";
        JDBCUtils.executeUpdate(sql,adminname,password,admin.getAdminname(),admin.getPassword());
    }

    /**
     * 根据id删除管理员
     *
     * @param id
     */
    @Override
    public void deleteAdmin(Integer id) {
        String sql = "delete from admin where id = ?";
        JDBCUtils.executeUpdate(sql,id);
    }

    /**
     * 添加管理员
     *
     * @param admin
     */
    @Override
    public void insertAdmin(Admin admin) {
        String sql = "insert into admin(adminname,password) values(?,?)";
        JDBCUtils.executeUpdate(sql,admin.getAdminname(),admin.getPassword());
    }
}
