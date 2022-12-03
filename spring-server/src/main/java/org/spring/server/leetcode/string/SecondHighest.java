package org.spring.server.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ty
 *
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * 混合字符串 由小写英文字母和数字组成。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 *
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 */
public class SecondHighest {

    public int secondHighest(String s) {
        int[] arr = new int[10];
        Arrays.fill(arr, 0);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 47 && c < 58) {
                arr[c - 48]++;
                set.add(c);
            }
        }
        if (set.isEmpty() || set.size() == 1) {
            return -1;
        }
        int count = 0;
        for (int i = 9; i >= 0; i--) {
            if (arr[i] > 0 ) {
                count ++;
            }
            if (count == 2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        int i = secondHighest.secondHighest("ck077");
        System.out.println(i);
    }
}
