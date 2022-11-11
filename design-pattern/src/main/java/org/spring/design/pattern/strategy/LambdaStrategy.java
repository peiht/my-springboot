package org.spring.design.pattern.strategy;

public class LambdaStrategy {
    public enum BuyStrategy implements ShopStrategy{
        GIFT(()->{
            System.out.println("gift");
        }),

        FLOWER(() -> {
            System.out.println("flower");
        });

        private final ShopStrategy strategy;

        BuyStrategy(ShopStrategy strategy) {
            this.strategy = strategy;
        }

        @Override
        public void buy() {
            strategy.buy();
        }
    }

}
