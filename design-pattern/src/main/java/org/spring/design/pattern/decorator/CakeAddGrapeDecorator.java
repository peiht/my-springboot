package org.spring.design.pattern.decorator;

import java.math.BigDecimal;

public class CakeAddGrapeDecorator extends CakeDecorator{
    public CakeAddGrapeDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getCakeMsg(){
        return super.getCakeMsg() + "加葡萄";
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice().add(BigDecimal.valueOf(5));
    }
}
