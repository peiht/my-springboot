package org.spring.server.org.spring.utils;

import java.util.Calendar;

public class DateUtil {

    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(year);
        System.out.println(month);
        for(int i=year-2;i<year;i++){
            for(int j=1;j<13;j++){
                System.out.println(String.valueOf(i)+"/"+String.valueOf(j));
            }
        }
        for(int a = 1;a<month+2;a++){
            System.out.println(String.valueOf(year)+"/"+String.valueOf(a));
        }
    }
}
