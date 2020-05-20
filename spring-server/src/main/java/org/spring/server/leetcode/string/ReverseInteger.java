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
        if (result == null){
            return 0;
        }
        //交换高低位的位置
        int num = 0;
        int j = 0;
        for (int i=result.size()-1; i>=0; i--){
            int y = (int) Math.pow(10, j);
            num = num + result.get(i) * y;
            j++;
        }
        if (tar == 1){
            return -num;
        }
        return num;
    }

    //TODO 数组越界待优化
    private List<Integer> getArray(int x){
        List<Integer> list = new ArrayList<>();
        int  count = 0;
        int temp = x;
        while (temp > 0){
            int n = x%10;
            list.add(n);
            temp = temp/10;
            count = count +1;
            if (x>214748364 || (x==214748364 && n>7)) { //整数最大的尾数是7，如果>7则溢出返回0
                return null;
            }
            //判断是否 小于 最小32位整数
            if (x<-214748364 || (x==-214748364 && n<-8)) {//整数最小的尾数是-8，如果<-8则溢出返回0
                return null;
            }
        }
        return list;
    }


    public int reverse1(int x) {
        int res = 0;//储存反转值
        while(x!=0) {
            int tmp = x % 10; //每次取末尾数字
            x = x / 10; //每次除以10向前移动移位
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) { //整数最大的尾数是7，如果>7则溢出返回0
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {//整数最小的尾数是-8，如果<-8则溢出返回0
                return 0;
            }
            res = res * 10 + tmp;//乘10向后移位+上取余的值
        }
        return res;
    }
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        Integer x = Integer.valueOf(1534236469);
        System.out.println(reverseInteger.reverse(x));
    }
}
