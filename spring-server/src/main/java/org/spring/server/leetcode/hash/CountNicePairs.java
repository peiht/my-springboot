package org.spring.server.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            int tmp = i, j = 0;
            while (tmp > 0) {
                j = j * 10 + tmp % 10;
                tmp /= 10;
            }
            res = (res + map.getOrDefault(i - j, 0))% mod;
            map.put(i-j, map.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {42,11,1,97};
        CountNicePairs countNicePairs = new CountNicePairs();
        int res = countNicePairs.countNicePairs(nums);
        System.out.println(res);
    }
}
