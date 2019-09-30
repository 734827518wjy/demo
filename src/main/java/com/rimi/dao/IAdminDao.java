package com.rimi.dao;

import com.rimi.entity.Admin;

import java.util.List;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:02
 */
public interface IAdminDao {

    /**
     * 查看所有管理员
     * @param admin
     */
    List<Admin> selectAll(Admin admin);

    Admin selectByAdminNameAndPassword(String adminName, String password);

    /**
     * 修改管理员名称或者密码
     * @param adminname
     * @param password
     */

    void updateAdmin(Admin admin, String adminname, String password);

    /**
     * 根据id删除管理员
     * @param id
     */
    void deleteAdmin(Integer id);

    /**
     * 添加管理员
     * @param admin
     */
    void insertAdmin(Admin admin);
}
