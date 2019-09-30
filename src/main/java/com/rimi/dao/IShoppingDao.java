package com.rimi.dao;

import com.rimi.entity.Books;
import com.rimi.entity.Shopping;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:02
 */
public interface IShoppingDao {
    /**
     * 添加商品到购物车
     * @param shopping
     */
    public void insertShopping(Map<String ,String[]> shopping);

    /**
     * 购买商品或者取消商品
     * @param shopping
     */
    public void deleteShopping(Map<String ,String []> shopping);

    /**
     * 查询已选择商品
     * @return
     */
    public List<Shopping> selectShopping();

    List<Shopping> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();

    void deleteById(Integer id);

    Shopping selectById(String id);
}
