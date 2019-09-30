package com.rimi.servlet;

import com.rimi.service.AdminService;
import com.rimi.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author wjy
 * @date 2019/9/27 0027 14:25
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //获取参数
        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");
        boolean login = adminService.login(adminname, password,request,response);
        if (login){
            request.getSession().setAttribute("adminname",adminname);
            response.sendRedirect("/Admin.jsp");
        }else{
            request.setAttribute("error5","账号不存在");
            request.getRequestDispatcher("/adminLogin.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
