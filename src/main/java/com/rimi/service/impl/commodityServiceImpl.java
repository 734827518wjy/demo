package com.rimi.service.impl;

import com.rimi.dao.ICommodityDao;
import com.rimi.dao.impl.CommodityDaoImpl;
import com.rimi.entity.commodity;
import com.rimi.service.commodityService;

import java.util.List;

/**
 * @author wjy
 * @date 2019/9/27 0027 10:54
 */
public class commodityServiceImpl implements commodityService {
    private ICommodityDao commodityDao = new CommodityDaoImpl();

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<commodity> GetAll() {
        return commodityDao.selectAllCommodity();
    }
}
