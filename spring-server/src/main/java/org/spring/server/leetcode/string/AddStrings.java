package org.spring.server.leetcode.string;

/**
 * @author hitopei
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1, j = len2;
        int car = 0;
        StringBuilder stringBuffer = new StringBuilder();
        while (i > 0 || j > 0) {

            String str1 = i > 0 ? num1.substring(i-1, i) : "0";
            String str2 = j > 0 ? num2.substring(j-1, j) : "0";
            int num = Integer.valueOf(str1) + Integer.valueOf(str2);
            int val = ( num + car)%10;
            stringBuffer.append(val);
            car = (num + car)/10;
            i--;
            j--;
        }
        if (car > 0) {
            stringBuffer.append(car);
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "999999";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings(num1, num2));
    }
}
