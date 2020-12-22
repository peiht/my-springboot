package org.spring.design.pattern.decorator;

import java.math.BigDecimal;

public class CakeAddMongoDecorator extends CakeDecorator{
    public CakeAddMongoDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getCakeMsg(){
        return super.getCakeMsg() + "加芒果";
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice().add(BigDecimal.valueOf(23));
    }
}
