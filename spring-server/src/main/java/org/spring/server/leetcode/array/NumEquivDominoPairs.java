package org.spring.server.leetcode.array;

public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes){
        int[] nums = new int[100];
        int res = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[0] + domino[1] * 10;
            res += nums[val];
            nums[val]++;
        }
        return res;
    }
}
