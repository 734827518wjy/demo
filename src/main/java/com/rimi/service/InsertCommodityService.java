package com.rimi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 添加图书操作
 *
 * @author wjy
 * @date 2019/9/27 0027 16:28
 */
public interface InsertCommodityService {

    /**
     * 添加商品
     * @param
     * @param
     * @param
     * @param
     * @return
     */


    void insertCommodity(Map<String, String[]> commodity);

    boolean JudeInsertCommodity(Map<String, String[]> commodity,String name,String introduction,BigDecimal press,Integer num);
}
