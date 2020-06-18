package org.spring.server.leetcode.array;

import java.util.Arrays;

/**
 * @author hitopei
 *
 *
 *给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *
 */
public class PivotIndex {
    /**
     * n还超出时间限制，就是arrays的操作超时了
     */
    public int pivotIndex1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int[] left = Arrays.copyOfRange(nums, 0, i);
            int[] right = Arrays.copyOfRange(nums, i+1, length);
            if (Arrays.stream(left).sum() == Arrays.stream(right).sum()) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int right = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0;  i < length; i ++) {
            if (left == right - nums[i]) {
                return i;
            }
            left += nums[i];
            right -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new PivotIndex().pivotIndex(nums));
    }
}
