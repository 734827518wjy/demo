package com.rimi.servlet;

import com.rimi.entity.User;
import com.rimi.service.impl.selectUserSerivceImpl;
import com.rimi.service.selectUserSerivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ${Description}
 *
 * @author wjy
 * @date 2019/9/29 0029 23:36
 */
@WebServlet("/selectUser")
public class selectUserServlet extends HttpServlet {
    private selectUserSerivce userSerivce = new selectUserSerivceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法获取用户集合
        List<User> users = userSerivce.selectAllUser();
        //设置转发位置名称
        request.setAttribute("users",users);
        //请求转发
        request.getRequestDispatcher("/selectUser.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
