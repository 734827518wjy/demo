package com.rimi.dao.impl;

import com.rimi.dao.IBorrowingDao;
import com.rimi.util.JDBCUtils;

import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/25 0025 17:17
 */
public class BorrowingDaoImpl implements IBorrowingDao {
    /**
     * 借阅图书
     *
     * @param borrowing
     */
    @Override
    public void insertBorrower(Map<String, String[]> borrowing) {
        String sql = "insert into borrowing(Borrower,bookName,phone,borrowing_time,return_time) values(?,?,?,?,?)";
        JDBCUtils.executeUpdate(sql,
                        borrowing.get("Borrower")[0],
                        borrowing.get("bookName")[0],
                        borrowing.get("phone")[0],
                        borrowing.get("borrowing_time")[0],
                        borrowing.get("return_time")[0]);
    }

    /**
     * 根据书名归还图书
     *
     * @param bookName
     */
    @Override
    public void deleteBorrower(String bookName) {
        String sql = "delete from borrowing where bookName = ?";
        JDBCUtils.executeUpdate(sql,bookName);
    }
}
