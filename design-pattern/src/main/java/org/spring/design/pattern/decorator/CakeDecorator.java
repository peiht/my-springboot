package org.spring.design.pattern.decorator;

import java.math.BigDecimal;

public abstract class CakeDecorator extends Cake{

    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String getCakeMsg(){
        return this.cake.getCakeMsg();
    }

    @Override
    public BigDecimal getPrice(){
        return this.cake.getPrice();
    }
}
