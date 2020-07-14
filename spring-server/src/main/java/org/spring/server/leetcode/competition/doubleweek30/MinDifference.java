package org.spring.server.leetcode.competition.doubleweek30;

/**
 * @author Administrator
 *
 * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个数字并将它改成任意值。
 *
 * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,3,2,4]
 * 输出：0
 * 解释：将数组 [5,3,2,4] 变成 [2,2,2,2].
 * 最大值与最小值的差为 2-2 = 0 。
 * 示例 2：
 *
 * 输入：nums = [1,5,0,10,14]
 * 输出：1
 * 解释：将数组 [1,5,0,10,14] 变成 [1,1,0,1,1] 。
 * 0,1,5,10,14
 * 1,4,5,4
 * 最大值与最小值的差为 1-0 = 1 。
 * 示例 3：
 *
 * 输入：nums = [6,6,0,1,1,4,6]
 * 0,1,1,4,6,6,6
 * 1,0,3,2,0,0
 * 输出：2
 * 示例 4：
 *
 * 输入：nums = [1,5,6,14,15]
 * 4,1,8,1
 * 输出：1
 */
public class MinDifference {

    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new MinDifference().minDifference(nums));
    }
}
