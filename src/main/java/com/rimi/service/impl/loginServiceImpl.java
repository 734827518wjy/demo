package com.rimi.service.impl;

import com.rimi.dao.IUserDao;
import com.rimi.dao.impl.IUserDaoImpl;
import com.rimi.entity.User;
import com.rimi.service.loginService;
import com.rimi.util.PWDUtils;
import com.rimi.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wjy
 * @date 2019/9/25 0025 15:03
 */
public class loginServiceImpl implements loginService {

    private IUserDao userDao = new IUserDaoImpl();

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @param
     * @param request
     * @param response
     * @return 是否成功登陆
     */
    @Override
    public boolean login(String username, String password,String remember, HttpServletRequest request, HttpServletResponse response) {
        // 判断用户名和密码是否为空
        if (StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)){
            User user = userDao.selectByUsernameAndPassword(username, password);
            return user != null;
        }
        return false;
    }


}
