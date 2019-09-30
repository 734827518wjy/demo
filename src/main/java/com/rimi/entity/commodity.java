package com.rimi.entity;

import java.math.BigDecimal;

/**
 * 商品
 *
 * @author wjy
 * @date 2019/9/24 0024 16:37
 */
public class commodity {
    private Integer id;
    private String name;
    private String introduction;
    private BigDecimal press;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPress() {
        return press;
    }

    public void setPress(BigDecimal press) {
        this.press = press;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


}
