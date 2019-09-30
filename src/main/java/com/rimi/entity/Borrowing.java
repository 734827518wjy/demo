package com.rimi.entity;

import java.util.Date;

/**
 * 借阅图书
 *
 * @author wjy
 * @date 2019/9/24 0024 17:01
 */
public class Borrowing {
    private Integer id;
    private String Borrower;
    private String bookName;
    private Integer phone;
    private Date borrowing_time;
    private Date return_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrower() {
        return Borrower;
    }

    public void setBorrower(String borrower) {
        Borrower = borrower;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getBorrowing_time() {
        return borrowing_time;
    }

    public void setBorrowing_time(Date borrowing_time) {
        this.borrowing_time = borrowing_time;
    }

    public Date getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Date return_time) {
        this.return_time = return_time;
    }
}
