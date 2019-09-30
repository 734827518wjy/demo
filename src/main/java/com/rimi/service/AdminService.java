package com.rimi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

/**
 * 管理员操作
 *
 * @author wjy
 * @date 2019/9/27 0027 14:26
 */
public interface AdminService {

    boolean login(String adminname, String password, HttpServletRequest request, HttpServletResponse resp);
}
