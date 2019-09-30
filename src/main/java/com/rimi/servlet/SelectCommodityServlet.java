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
 * @date 2019/9/29 0029 20:37
 */
@WebServlet("/selectCommodityMore")
public class SelectCommodityServlet extends HttpServlet {
    private commodityService commodityService = new commodityServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法获取商品
        List<commodity> commodities = commodityService.GetAll();
        //设置转发位置名称
        request.setAttribute("commodity1",commodities);
        request.getRequestDispatcher("/selectCommodity.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
