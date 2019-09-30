package com.rimi.dao.impl;

import com.rimi.dao.ICommodityDao;
import com.rimi.entity.commodity;
import com.rimi.util.JDBCUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/25 0025 17:39
 */
public class CommodityDaoImpl implements ICommodityDao {
    /**
     * 添加商品
     *
     * @param commodity
     */
    @Override
    public void inertCommodity(Map<String, String[]> commodity) {
        String sql = "insert into commodity(name,introduction,press,num) values(?,?,?,?)";
        JDBCUtils.executeUpdate(sql,
                        commodity.get("name")[0],
                        commodity.get("introduction")[0],
                        commodity.get("press")[0],
                        commodity.get("num")[0]);
    }

    /**
     * 根据名称和ID下架商品
     *
     * @param box
     */
    @Override
    public void deleteCommodity(String box) {
        String sql = "delete from commodity where id = ?";
        JDBCUtils.executeUpdate(sql,box);
    }

    /**
     * 修改商品
     *
     * @param commodity
     */
    @Override
    public void updateCommodity(Map<String, String[]> commodity) {
        String sql = "update commodity set name = ?" +
                ",introduction = ?" +
                ",press = ?" +
                ",num = ? where id = ?";
        JDBCUtils.executeUpdate(sql,
                commodity.get("name")[0],
                commodity.get("introduction")[0],
                commodity.get("press")[0],
                commodity.get("num")[0],
                commodity.get("id")[0]);
    }

    /**
     * 查询商品
     *
     * @return
     */
    @Override
    public List<commodity> selectAllCommodity() {
        String sql = "select * from commodity";
        return JDBCUtils.executeQuery(commodity.class,sql);
    }

    @Override
    public commodity selectById(Integer id) {
        String sql = "select * from commodity where id = ?";
        return JDBCUtils.executeQueryForOne(commodity.class, sql, id);

    }


}
