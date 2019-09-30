package com.rimi.entity;

import java.math.BigDecimal;

/**
 * 图书
 *
 * @author wjy
 * @date 2019/9/24 0024 17:00
 */
public class Books {
    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String bookPrice;
    private BigDecimal bookPress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BigDecimal getBookPress() {
        return bookPress;
    }

    public void setBookPress(BigDecimal bookPress) {
        this.bookPress = bookPress;
    }
}
