package com.rimi.servlet;

import com.rimi.entity.Shopping;
import com.rimi.service.ShoppingService;
import com.rimi.service.impl.ShoppingServiceImpl;

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
 * @date 2019/9/30 0030 9:13
 */
@WebServlet("/selectShopping")
public class selectShoppingServlet extends HttpServlet {
    private ShoppingService shoppingService = new ShoppingServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.getRequestDispatcher("UTF-8");
        //使用方法获取数据集合
        List<Shopping> shopping = shoppingService.getAll();
        //设置参数名称
        request.setAttribute("shopping",shopping);
        //请求转发
        request.getRequestDispatcher("/shopping.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
