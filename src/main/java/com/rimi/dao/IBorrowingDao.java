package com.rimi.dao;

import com.rimi.entity.Borrowing;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/24 0024 17:03
 */
public interface IBorrowingDao {

    /**
     * 借阅图书
     * @param borrowing
     */
    public void insertBorrower(Map<String , String[]> borrowing);

    /**
     * 归还图书
     * @param bookName
     */
    public void deleteBorrower(String bookName);
}
