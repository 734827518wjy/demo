package com.rimi.dao;

import com.rimi.entity.commodity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:03
 */
public interface ICommodityDao {

    /**
     * 添加商品
     * @param commodity
     */
    public void inertCommodity(Map<String , String[]> commodity);

    /**
     * 根据名称删除/下架商品
     * @param
     */
    public void deleteCommodity(String box);

    /**
     * 修改商品
     * @param commodity
     */
    public void updateCommodity(Map<String ,String[]> commodity );

    /**
     * 查询商品
     * @return
     */
    public List<commodity> selectAllCommodity();


    commodity selectById(Integer id);
}
