package org.spring.server.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * @author hitopei
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0){
            return 0;
        }
        int tar = 0;
        if (x > 0){

        }else {
            tar = 1;
            x = -x;
        }
        //转换成数组
        List<Integer> result = this.getArray(x);
        //交换高低位的位置
        int num = 0;
        for (int i=result.size()-1; i>=0; i--){
            num = num + result.get(i) * 10;
        }
        return 0;
    }

    private List<Integer> getArray(int x){
        List<Integer> list = new ArrayList<>();
        int  count = 0;
        while (x > 10){
            int n = x%10;
            list.add(n);
            x = x/10;
            count = count +1;
        }
        return list;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        Integer x = Integer.valueOf(123456);
        System.out.println(Integer.reverse(x));
    }
}
