package com.rimi.service.impl;

import com.rimi.dao.ICommodityDao;
import com.rimi.dao.impl.CommodityDaoImpl;
import com.rimi.entity.commodity;
import com.rimi.service.InsertCommodityService;
import com.rimi.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/27 0027 16:30
 */
public class InsertCommodityServiceImpl implements InsertCommodityService {
    private ICommodityDao commodityDao = new CommodityDaoImpl();
    /**
     * 添加商品
     *
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @Override
    public void insertCommodity(Map<String, String[]> commodity) {
        commodityDao.inertCommodity(commodity);
    }

    @Override
    public boolean JudeInsertCommodity(Map<String, String[]> commodity,String name,String introduction,BigDecimal press,Integer num){
        Integer i = 0;
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(introduction) && i.equals(press) && num > 0){
            return true;
        }
        return false;
    }
}
