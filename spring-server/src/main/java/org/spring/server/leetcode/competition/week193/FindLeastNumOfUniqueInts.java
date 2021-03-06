package org.spring.server.leetcode.competition.week193;

import java.util.*;

/**
 * @author hitopei
 *
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 */
public class FindLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //移除的是出现次数最少的k个元素
        int[] temp = new int[arr.length];
        int[] array = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) +1);
            }else {
                map.put(num, 1);
            }
        }

        map.forEach((key, value) -> {
            temp[value] = temp[value] + value;
            array[value] = array[value] +1;
        });

        int count = 0;
        for (int i = 1; i<temp.length; i++) {
            if (k >= 0 ) {
                k = k - temp[i] * i;
            }

        }



        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1,8,3,5,1,3};
        int k = 3;
        System.out.println(new FindLeastNumOfUniqueInts().findLeastNumOfUniqueInts(arr, k));
    }
}
