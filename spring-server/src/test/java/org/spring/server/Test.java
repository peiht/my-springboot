package org.spring.server;


import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        long size = 13192519221248L;
        long byteSize = size >> 10;
        long mSize = byteSize >> 10;
        long gSize = size >> 10 >> 10 >> 10;

        long free = 10027486519296L >> 10 >> 10 >> 10;
        System.out.println(gSize);
        System.out.println(free);

        BigDecimal bigDecimal = BigDecimal.valueOf(free)
                .multiply(BigDecimal.valueOf(100));
        BigDecimal decimal = bigDecimal.divide(BigDecimal.valueOf(gSize), BigDecimal.ROUND_CEILING);
        DecimalFormat decimalFormat = new DecimalFormat(".00");

        System.out.println(decimalFormat.format(decimal));
    }
}
