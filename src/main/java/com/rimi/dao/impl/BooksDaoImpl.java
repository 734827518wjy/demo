package com.rimi.dao.impl;

import com.rimi.dao.IBooksDao;
import com.rimi.entity.Books;
import com.rimi.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author wjy
 * @date 2019/9/25 0025 16:42
 */
public class BooksDaoImpl implements IBooksDao {
    @Override
    public List<Books> selectBooksAll() {
        String sql = "select * from books";
        return JDBCUtils.executeQuery(Books.class,sql);
    }




    @Override
    public void updateBooks(Map<String , String[]> books) {
        String sql = "update books set book_name = ?" +
                ",book_author = ?" +
                ",book_price = ?" +
                ",book_ISBM = ?" +
                ",book_press = ?" +
                ",book_category = ? where id = ?";
        JDBCUtils.executeUpdate(sql,
                books.get("bookName")[0],
                books.get("bookAuthor")[0],
                books.get("bookPrice")[0],
                books.get("bookISBM")[0],
                books.get("bookPress")[0],
                books.get("bookCategory")[0],
                books.get("id")[0]);
    }

    @Override
    public void deleteBooks(Integer id) {
        String sql = "delete from books where id =?";
        JDBCUtils.executeUpdate(sql,id);
    }

    @Override
    public void insertBooks(Map<String, String[]> books) {
        String sql = "insert into books(bookName,bookAuthor,bookPrice,bookPress) where values(?,?,?,?)";
        JDBCUtils.executeUpdate(sql,
                                books.get("bookName")[0],
                                books.get("bookAuthor")[0],
                                books.get("bookPrice")[0],
                                books.get("bookPress")[0]);
    }
}
