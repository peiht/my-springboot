package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *
 * @title 最大连续的1的个数
 *
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class FindMaxConsecutiveOnes {

    /**
     * 正常逻辑，统计1的最大连续长度
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }else{
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }


    /**
     * 滑动窗口方法
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int maxSize = 0;
        while (right < length) {
            if (nums[right++] == 0) {
                maxSize = Math.max(maxSize, right - left - 1);
                //左指针移动到有指针的位置
                left = right;
            }

        }
        return Math.max(maxSize, right - left);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes1(nums));
    }
}
