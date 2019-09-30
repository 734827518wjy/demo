package com.rimi.entity;

import sun.awt.image.BufferedImageGraphicsConfig;

import java.math.BigDecimal;

/**
 * 购物车
 *
 * @author wjy
 * @date 2019/9/24 0024 17:01
 */
public class Shopping {
    private String username;
    private String commodity;
    private BigDecimal press;
    private Integer number;
    private BigDecimal totalPrice;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public BigDecimal getPress() {
        return press;
    }

    public void setPress(BigDecimal press) {
        this.press = press;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
