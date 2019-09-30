package com.rimi.service.impl;

import com.rimi.dao.IUserDao;
import com.rimi.dao.impl.IUserDaoImpl;
import com.rimi.entity.User;
import com.rimi.service.registeredSerivce;
import com.rimi.util.PWDUtils;
import com.rimi.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/26 0026 10:17
 */
public class registeredSerivceImpl implements registeredSerivce {
    private IUserDao userDao = new IUserDaoImpl();

    /**
     * 注册相关操作
     *
     * @param registeredName
     * @param registPwd
     * @param registPwd2
     * @param req
     * @param resp
     * @return
     */
    @Override
    public boolean registered(String registeredName, String registPwd, String registPwd2, HttpServletRequest req, HttpServletResponse resp) {
        //判断是否为null
        if (StringUtils.isNotEmpty(registeredName) && StringUtils.isNotEmpty(registPwd) && StringUtils.isNotEmpty(registPwd2)){
            User user = userDao.selectByUsername(registeredName);
            return user != null;
        }
        return false;
    }

    @Override
    public void save(Map<String, String[]> params){
        // 插入默认密码 000000
        // 对密码进行加密,使用MD5
        String pwd = PWDUtils.getPwd(params.get("registeredName")[0] + "000000");
        //把密码存入到集合中
        //调用方法
        userDao.insertUser(params,pwd);
    }

    @Override
    public boolean registeredPwd(String Pwd1,String Pwd2,HttpServletRequest request,HttpServletResponse response){
        //判断输入密码是否相同
        if (StringUtils.isNotEmpty(Pwd1) && StringUtils.isNotEmpty(Pwd2)){
            if (Pwd1.equals(Pwd2)){
                return true;
            }
        }
        return false;
    }
}
