package com.rimi.service.impl;

import com.rimi.dao.ICommodityDao;
import com.rimi.dao.impl.CommodityDaoImpl;

import com.rimi.service.DeleteCommodityService;
import com.rimi.util.deleteUtil;


/**
 * @author wjy
 * @date 2019/9/29 0029 17:49
 */
public class DeleteServiceImpl implements DeleteCommodityService {
    private ICommodityDao commodityDao = new CommodityDaoImpl();
    /**
     * 下架商品操作
     *
     *
     * @param box
     * @return
     */
    @Override
    public void deleteCommodity(String box) {
        boolean delete = deleteUtil.delete(box);
        if (delete) {
            commodityDao.deleteCommodity(box);
        }
    }
}
