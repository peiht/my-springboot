package org.spring.server.leetcode.competition.doubleweek29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hitopei
 *
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 *
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 *
 * 输入：nums = [0,0,0]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 */
public class LongestSubarray {

    /**
     *
     * 滑动窗口，根据求和判断含0的次数，再求距离的最大值
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        int sum = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while ( i < j && sum < j - i) {
                sum -= nums[i++];
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int longestSubarray1(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][2];

        dp[0][1] = -1;

        int max = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                dp[i+1][0] = 0;
                dp[i+1][1] = dp[i][0];
            }else {
                dp[i+1][0] = dp[i][0] + 1;
                dp[i+1][1] = dp[i][1] + 1;
            }
            max = Math.max(max, dp[i+1][1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(new LongestSubarray().longestSubarray1(nums));
    }
}
