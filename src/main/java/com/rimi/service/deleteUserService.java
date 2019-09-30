package com.rimi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除用户
 *
 * @author wjy
 * @date 2019/9/29 0029 15:17
 */
public interface deleteUserService {

    /**
     * 删除用户操作
     * @param
     * @param username
     * @param password
     * @param request
     * @param resp
     * @return
     */
    boolean deleteUser(String username, String password, HttpServletRequest request, HttpServletResponse resp);

}
