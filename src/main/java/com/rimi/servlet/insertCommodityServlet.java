package com.rimi.servlet;

import com.rimi.service.InsertCommodityService;
import com.rimi.service.impl.InsertCommodityServiceImpl;

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
 * @date 2019/9/27 0027 16:27
 */
@WebServlet("/insertCommodity")
public class insertCommodityServlet extends HttpServlet {
    private InsertCommodityService commodityService = new InsertCommodityServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        commodityService.insertCommodity(parameterMap);
        if (parameterMap != null){
            request.getRequestDispatcher("/addCommodity.jsp").forward(request,response);
        }else{
            request.setAttribute("error6","添加失败");
            request.getRequestDispatcher("/addCommodity.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
