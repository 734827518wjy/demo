package com.rimi.dao.impl;

import com.rimi.dao.IShoppingDao;
import com.rimi.entity.Shopping;
import com.rimi.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/25 0025 17:57
 */
public class ShoppingDaoImpl implements IShoppingDao {
    /**
     * 添加商品到购物车
     *
     * @param shopping
     */
    @Override
    public void insertShopping(Map<String, String[]> shopping) {
        String sql = "insert into shopping(username,commodity,press,number,totalPrice)";
        JDBCUtils.executeUpdate(sql,
                shopping.get("username")[0],
                shopping.get("commodity")[0],
                shopping.get("press")[0],
                shopping.get("number")[0],
                shopping.get("totalPrice")[0]);
    }

    /**
     * 购买商品或者取消商品
     *
     * @param shopping
     */
    @Override
    public void deleteShopping(Map<String, String[]> shopping) {
        String sql = "update shopping set username = ?" +
                ",commodity = ?" +
                ",press = ?" +
                ",number = ?" +
                ",totalPrice = ? where id =?";
        JDBCUtils.executeUpdate(sql,shopping.get("username")[0],
                shopping.get("commodity")[0],
                shopping.get("press")[0],
                shopping.get("number")[0],
                shopping.get("totalPrice")[0],
                shopping.get("id")[0]);
    }


    /**
     * 查询已选择商品
     *
     * @return
     */
    @Override
    public List<Shopping> selectShopping() {
        String sql = "select * from Shopping";
        return JDBCUtils.executeQuery(Shopping.class,sql);
    }

    /**
     * 设置分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Shopping> selectByPage(Integer currentPage, Integer pageSize) {
        String sql = "select * from shopping limit ?,?";
        if (currentPage > 0){
            currentPage -= 1;
        }else{
            currentPage = 0;
        }
        return JDBCUtils.executeQuery(Shopping.class,sql,currentPage,pageSize);
    }


    @Override
    public Integer count() {
        String sql = "select count(1) from books";
        return JDBCUtils.executeQueryForCount(sql);
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from shopping where id = ?";
        JDBCUtils.executeUpdate(sql,id);
    }

    @Override
    public Shopping selectById(String id) {
        String sql = "select * from shopping where id = ?";
        return JDBCUtils.executeQueryForOne(Shopping.class,sql,id);
    }
}
