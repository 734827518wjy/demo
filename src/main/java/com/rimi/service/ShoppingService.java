package com.rimi.service;

import com.rimi.common.Page;
import com.rimi.entity.Shopping;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:04
 */
public interface ShoppingService {
    void save(Map<String, String[]> params);


    List<Shopping> getAll();

    Page<Shopping> findPagedShopping(Page page);

    Shopping findById(String id);

    void update(Map<String ,String []> shopping);

    void deleteById(Integer id);

    void deleteByIds(String[] ids);

}
