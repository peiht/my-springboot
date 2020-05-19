package org.spring.server.leetcode;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * @author hitopei
 */
public class ArrayPlusOne {

    /**
     * 校验过多，笨方法
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        if (Arrays.stream(digits).allMatch(e -> e == 9)){
            int[] digitsNew = new int[length+1];
            digitsNew[0] = 1;
            for (int i=1; i<digitsNew.length; i++){
                digitsNew[i] = 0;
            }
            return digitsNew;
        }
        int temp = 0;
        for (int i=length-1; i>=0; i --){
            int num = digits[i];
            if (num == 9 && temp == 1){
                digits[i] = 0;
                temp = 1;
            }else if (i == length-1 ){
                if (num == 9){
                    digits[i] = 0;
                    temp = 1;
                }else {
                    digits[i] = num + 1;
                }
            }else {
                if (temp == 1){
                    digits[i] = num + 1;
                    temp = temp -1;
                }
            }
        }

        return digits;
    }

    public int[] plusOne1(int[] digits){
        if (digits == null || digits.length == 0){
            return new int[0];
        }
        int carry = 0;
        for (int i= digits.length-1; i >= 0; i --){
            if (i== digits.length-1){
                digits[i] = digits[i] + carry+1;
            }else {
                digits[i] = digits[i] + carry;
            }
            int num = digits[i];
            int a = num/10;
            if (a == 1){
                carry = 1;
                digits[i] = 0;
            }else {
                carry = 0;
            }
        }
        if (digits[0] == 0){
            int[] digitsNew = new int[digits.length+1];
            digitsNew[0] = 1;
            for (int i=1; i<digitsNew.length; i++){
                digitsNew[i] = 0;
            }
            return digitsNew;
        }
        return digits;
    }

    public static void main(String[] args) {
        ArrayPlusOne arrayPlusOne = new ArrayPlusOne();
        int[] array = {2,4,9,3,9};
        int[] arr  =  arrayPlusOne.plusOne1(array);
        System.out.println(Arrays.toString(arr));

//        System.out.println(10/10);
//        System.out.println(10%10);

    }
}
