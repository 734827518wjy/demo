package com.rimi.servlet;

import com.rimi.entity.commodity;
import com.rimi.service.commodityService;
import com.rimi.service.impl.commodityServiceImpl;

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
 * @date 2019/9/27 0027 10:50
 */
@WebServlet("/commodity")
public class commomdityServlet extends HttpServlet {
    private commodityService commodityService = new commodityServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法获取商品
        List<commodity> commodities = commodityService.GetAll();
        //设置转发位置名称
        request.setAttribute("commodity",commodities);
        //请求转发
        request.getRequestDispatcher("/commodity.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
