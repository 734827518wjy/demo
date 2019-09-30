package com.rimi.dao;

import com.rimi.entity.Books;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:02
 */
public interface IBooksDao {

    /**
     * 查询所有图书
     * @return
     */
    List<Books> selectBooksAll();

    /**
     * 修改图书
     * @param books
     */
    void updateBooks(Map<String , String[]> books);

    /**
     * 根据id删除图书
     * @param id
     */
    void deleteBooks(Integer id);

    /**
     * 添加图书
     * @param books
     */
    void insertBooks(Map<String,String[]> books);
}
