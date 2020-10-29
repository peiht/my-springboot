package org.spring.server.designPattern.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        Cake cake = null;

        cake = new BaseCake();
        System.out.println(cake.getCakeMsg() + cake.getPrice().toString());

        cake = new CakeAddGrapeDecorator(cake);
        System.out.println(cake.getCakeMsg() + cake.getPrice().toString());

        cake = new CakeAddMongoDecorator(cake);
        System.out.println(cake.getCakeMsg() + cake.getPrice().toString());
    }
}
