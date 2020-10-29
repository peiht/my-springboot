package org.spring.server.designPattern.decorator;

import java.math.BigDecimal;
import java.util.Calendar;

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
