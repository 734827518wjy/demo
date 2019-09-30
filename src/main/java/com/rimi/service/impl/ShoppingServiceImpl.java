package com.rimi.service.impl;

import com.rimi.common.Page;
import com.rimi.dao.IShoppingDao;
import com.rimi.dao.impl.ShoppingDaoImpl;
import com.rimi.entity.Shopping;
import com.rimi.service.ShoppingService;
import com.rimi.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/26 0026 15:28
 */
public class ShoppingServiceImpl implements ShoppingService {
    private IShoppingDao shoppingDao = new ShoppingDaoImpl();


    @Override
    public void save(Map<String, String[]> params) {
        // 把数据插入到数据库中
        shoppingDao.insertShopping(params);
    }

    @Override
    public List<Shopping> getAll() {
        // 查询数据库
        return shoppingDao.selectShopping();
    }

    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页后的信息
     */
    @Override
    public Page<Shopping> findPagedShopping(Page page) {
        // 分页查询
        // 0. 获取分页的条件
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        // 1. 通过分页条件查询,并获取结果列表
        List<Shopping> shoppingList = shoppingDao.selectByPage(currentPage,pageSize);
        // 2. 通过查询获取总条数
        Integer count = shoppingDao.count();
        // 把结果存放到page对象中
        page.setPageData(shoppingList);
        page.setTotalCount(count);
        return page;
    }

    @Override
    public Shopping findById(String id){
        //调用Dap方法,获取数据
        if (StringUtils.isNotEmpty(id)){
            return shoppingDao.selectById(id);
        }
        return null;
    }

    @Override
    public void update(Map<String , String[]> shopping) {
        shoppingDao.deleteShopping(shopping);
    }

    @Override
    public void deleteById(Integer id) {
        //删除
        shoppingDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            deleteById(Integer.valueOf(id));
        }
    }
}
