package org.spring.server.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hitopei
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例：
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class FindSubArray {

    public int findNum(int[] nums, int k){
        int length = nums.length;
        if (length < 1){
            return 0;
        }
        int count = 0;
        for (int i=0; i<length; i++){
            int sum = 0;
            for (int end = i; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            int pre = preSum - k;
            if (preSumFreq.containsKey(pre)) {
                count += preSumFreq.get(pre);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        FindSubArray findSubArray = new FindSubArray();
        System.out.println(findSubArray.findNum(nums, 2));
        System.out.println(findSubArray.subarraySum(nums, 5));
    }
}
