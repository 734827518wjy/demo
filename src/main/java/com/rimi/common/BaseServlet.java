package com.rimi.common;

import com.rimi.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 公共servlet
 *
 * @author wjy
 * @date 2019/9/17 0017 14:46
 */
public abstract class BaseServlet extends HttpServlet {

    private static final String METHOD_KEY = "method";
    private static final String METHOD_PREFIX = "do";
    private static final String PATH_PREFIX = "redirect:";
    /**
     * s视图的前缀
     */
    private static final String VIEW_PREFIX = "/WEB-INF/view/";
    /**
     * 视图的后缀
     */
    private static final String VIEW_SUFFIX = ".jsp";

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        //req.setCharacterEncoding("UTF-8");
        //获取请求的参数
        String method = req.getParameter(METHOD_KEY);
        //判断方法是否存在
        if (StringUtils.isNotEmpty(method)){
            //使用工具类把add方法转换成doAdd方法
            String doMethod = StringUtils.appendDoMethod(METHOD_PREFIX, method);
            //获取当前类的类类型
            Class<?> aClass = this.getClass();
            try {
                //通过反射获取方法
                Method method1 = aClass.getMethod(doMethod, HttpServletRequest.class, HttpServletResponse.class);
                //调用方法,得到返回方法
                Object result = method1.invoke(this, req, resp);
                //判断返回值的类型是否是String
                if (result instanceof String){
                    String path = (String)result;
                    if (StringUtils.isNotEmpty(path)){
                        //判断路径是否以 redirect: 开头,如果是,则调用重定向
                        if (path.startsWith(PATH_PREFIX)){
                            //截取
                            String substring = path.substring(PATH_PREFIX.length());
                            //重定向
                            resp.sendRedirect(req.getContextPath()+substring);
                        }else {
                            //情求转发  /book/list --> /WEB-INF/view/book/list.jsp
                            req.getRequestDispatcher(VIEW_PREFIX+path+VIEW_SUFFIX).forward(req,resp);
                        }
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
