package com.rimi.servlet;

import com.rimi.dao.IUserDao;
import com.rimi.dao.impl.IUserDaoImpl;
import com.rimi.service.deleteUserService;
import com.rimi.service.impl.deleteUserServiceImpl;

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
 * @date 2019/9/29 0029 15:19
 */
@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
    private deleteUserService userService = new deleteUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean deleteUser = userService.deleteUser(username, password, request, response);
        if (deleteUser){
            request.setAttribute("error8","删除成功!!!!!!");
            request.getRequestDispatcher("/deleteUser.jsp").forward(request,response);
        }else{
            request.setAttribute("error7","没有找到该用户!!");
            request.getRequestDispatcher("/deleteUser.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
