package com.rimi.servlet;

import com.rimi.service.impl.loginServiceImpl;
import com.rimi.service.loginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author wjy
 * @date 2019/9/23 0023 16:38
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
    private loginService loginService = new loginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //获取页面参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        //判断是否存在数据库
        boolean login = loginService.login(username, password,remember, request, response);
        if (login){
            request.getSession().setAttribute("username",username);
            response.sendRedirect(request.getContextPath()+"/commodity");
        }else{
            request.setAttribute("error","用户名或者密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
