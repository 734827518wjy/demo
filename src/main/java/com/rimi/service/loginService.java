package com.rimi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆服务业务
 *
 * @author wjy
 * @date 2019/9/24 0024 14:39
 */
public interface loginService {

    /**
     *登陆
     * @param username
     * @param password
     * @param
     * @param request
     * @param response
     * @return 是否成功登陆
     */
    boolean login(String username, String password,String remember, HttpServletRequest request, HttpServletResponse response);


}
