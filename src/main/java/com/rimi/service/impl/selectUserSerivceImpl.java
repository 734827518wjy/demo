package com.rimi.service.impl;

import com.rimi.dao.IUserDao;
import com.rimi.dao.impl.IUserDaoImpl;
import com.rimi.entity.User;
import com.rimi.service.selectUserSerivce;

import java.util.List;

/**
 * @author wjy
 * @date 2019/9/29 0029 23:35
 */
public class selectUserSerivceImpl implements selectUserSerivce {
    private IUserDao userDao = new IUserDaoImpl();
    /**
     * 查询用户操作
     *
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        return userDao.selectAll();
    }
}
