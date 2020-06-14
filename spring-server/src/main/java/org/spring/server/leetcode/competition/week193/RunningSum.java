package org.spring.server.leetcode.competition.week193;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 */
public class RunningSum {

    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length+1];
        result[0] = 0;
        for (int i = 0; i < length; i++) {
            result[i+1] = result[i] + nums[i];
        }
        return Arrays.copyOfRange(result, 1, length+1);
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new RunningSum().runningSum(nums)));
    }
}
