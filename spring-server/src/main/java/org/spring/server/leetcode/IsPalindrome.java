package org.spring.server.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hitopei
 *
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public boolean isPalindrome(int x){
        String str = String.valueOf(x);
        int start = 0;
        int end = str.length()-1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome1(int x){
        if (x < 0) {
            return false;
        }
        List<Integer> list = toArray(x);
        int start = 0;
        int end = list.size()-1;
        while (start <= end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public List<Integer> toArray(int x) {
        List<Integer> list = new ArrayList<>();
        while (x/10 > 0){
            list.add(x%10);
            x = x/10;
        }
        list.add(x);
        return list;
    }

    public static void main(String[] args) {
        int x = -11;
        System.out.println(new IsPalindrome().isPalindrome1(x));
//        List<Integer> result = new IsPalindrome().toArray(x);
//        result.forEach(System.out::println);
    }
}
