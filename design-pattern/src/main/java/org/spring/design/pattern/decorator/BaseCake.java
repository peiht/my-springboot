package org.spring.design.pattern.decorator;

import java.math.BigDecimal;

public class BaseCake extends Cake{

    @Override
    public String getCakeMsg() {
        return "一块8寸普通蛋糕";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(68);
    }
}
