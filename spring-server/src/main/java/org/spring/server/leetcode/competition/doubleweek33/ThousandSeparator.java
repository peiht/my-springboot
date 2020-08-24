package org.spring.server.leetcode.competition.doubleweek33;

/**
 * @author hitopei
 *
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 987
 * 输出："987"
 * 示例 2：
 *
 * 输入：n = 1234
 * 输出："1.234"
 * 示例 3：
 *
 * 输入：n = 123456789
 * 输出："123.456.789"
 * 示例 4：
 *
 * 输入：n = 0
 * 输出："0"
 *
 * 提示：
 *
 * 0 <= n < 2^31
 */
public class ThousandSeparator {
    public String thousandSeparator(int n) {
        String val = String.valueOf(n);
        StringBuilder stringBuilder = new StringBuilder();
        int temp = 0;
        for (int i = val.length()-1; i >= 0; i--) {
            if (temp != 0 && temp%3 == 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(val.charAt(i));
            temp++;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ThousandSeparator().thousandSeparator(123456789));
    }
}
