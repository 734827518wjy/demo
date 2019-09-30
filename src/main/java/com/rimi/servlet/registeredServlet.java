package com.rimi.servlet;

import com.rimi.dao.IUserDao;
import com.rimi.dao.impl.IUserDaoImpl;
import com.rimi.service.impl.loginServiceImpl;
import com.rimi.service.impl.registeredSerivceImpl;
import com.rimi.service.loginService;
import com.rimi.service.registeredSerivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * ${Description}
 *
 * @author wjy
 * @date 2019/9/25 0025 14:29
 */
@WebServlet("/registered")
public class registeredServlet extends HttpServlet {
    private registeredSerivce registeredSerivce = new registeredSerivceImpl();
    private IUserDao userDao = new IUserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //获取注册页面请求参数
        String registeredName = request.getParameter("registeredName");
        String registPwd = request.getParameter("registPwd");
        String registPwd2 = request.getParameter("registPwd2");
        boolean registered = registeredSerivce.registered(registeredName, registPwd, registPwd2, request, response);
        boolean registeredPwd = registeredSerivce.registeredPwd(registPwd, registPwd2,request,response);
        if (!registered && registeredPwd){
            Map<String, String[]> registMap1 = request.getParameterMap();
            registeredSerivce.save(registMap1);
            request.setAttribute("error4","注册成功!3秒后返回");
            try{
                Thread.sleep(3000);
            }catch (Exception e){
            }
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else if (registered){
            request.setAttribute("error2","注册失败,账号以存在");
            request.getRequestDispatcher("/registered.jsp").forward(request,response);
        }else if(!registeredPwd){
            request.setAttribute("error3","两次密码输入不一致");
            request.getRequestDispatcher("/registered.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
