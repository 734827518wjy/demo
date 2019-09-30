package com.rimi.servlet;

import com.rimi.service.DeleteCommodityService;
import com.rimi.service.impl.DeleteServiceImpl;

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
 * @date 2019/9/29 0029 17:33
 */
@WebServlet("/deleteCommodity")
public class DeleteCommodityServlet extends HttpServlet {
    private DeleteCommodityService commodityService = new DeleteServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String box = request.getParameter("box");
        //是否下架成功
        commodityService.deleteCommodity(box);
        //请求转发ServletException
        request.getRequestDispatcher("/selectCommodityMore").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
