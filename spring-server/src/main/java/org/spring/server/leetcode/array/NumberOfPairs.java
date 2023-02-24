package org.spring.server.leetcode.array;

import java.util.Arrays;

public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[100];
        Arrays.fill(arr, 0);
        for (int num : nums) {
            arr[num]++;
        }

        int pair = 0, res = 0;
        for (int num : arr) {
            int a = num/2;
            pair = a + pair;
            int b = num%2;
            res = res + b;
        }
        int[] ans = new int[2];
        ans[0] = pair;
        ans[1] = res;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1,3,2,2};
        NumberOfPairs numberOfPairs = new NumberOfPairs();
        System.out.println(Arrays.toString(numberOfPairs.numberOfPairs(nums)));
        System.out.println(4/2);
        System.out.println(4%2);
    }
}
