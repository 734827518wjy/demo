package com.rimi.service.impl;

import com.rimi.dao.IUserDao;
import com.rimi.dao.impl.IUserDaoImpl;
import com.rimi.entity.User;
import com.rimi.service.deleteUserService;
import com.rimi.util.StringUtils;
import com.rimi.util.deleteUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wjy
 * @date 2019/9/29 0029 15:20
 */
public class deleteUserServiceImpl implements deleteUserService {
    private IUserDao userDao = new IUserDaoImpl();
    /**
     * 删除用户操作
     *
     * @param username
     * @param password
     * @param request
     * @param resp
     * @return
     */
    @Override
    public boolean deleteUser(String username, String password, HttpServletRequest request, HttpServletResponse resp) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
            User user = userDao.selectByUsernameAndPassword(username, password);
            if (user != null){
                userDao.deleteUser(username);
                return user != null;
            }
        }
        return false;
    }
}
