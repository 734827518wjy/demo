package com.rimi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 注册操作
 *
 * @author wjy
 * @date 2019/9/26 0026 10:14
 */
public interface registeredSerivce {

    /**
     * 注册相关操作
     * @param registeredName
     * @param registPwd
     * @param registPwd2
     * @param req
     * @param resp
     * @return
     */
    boolean registered(String registeredName, String registPwd, String registPwd2, HttpServletRequest req, HttpServletResponse resp);

    void save(Map<String, String[]> params);

    boolean registeredPwd(String Pwd1,String Pwd2,HttpServletRequest request,HttpServletResponse response);
}
