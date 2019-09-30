package com.rimi.service.impl;

import com.rimi.dao.IAdminDao;
import com.rimi.dao.impl.AdminDaoImpl;
import com.rimi.entity.Admin;
import com.rimi.service.AdminService;
import com.rimi.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wjy
 * @date 2019/9/27 0027 15:33
 */
public class AdminServiceImpl implements AdminService {
    private IAdminDao adminDao = new AdminDaoImpl();
    @Override
    public boolean login(String adminname, String password, HttpServletRequest request, HttpServletResponse resp) {
        if (StringUtils.isNotEmpty(adminname) && StringUtils.isNotEmpty(password)){
            Admin admin = adminDao.selectByAdminNameAndPassword(adminname, password);
            return admin != null;
        }
        return false;
    }
}
