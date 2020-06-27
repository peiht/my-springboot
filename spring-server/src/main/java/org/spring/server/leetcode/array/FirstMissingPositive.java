package org.spring.server.leetcode.array;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositive {

    /**
     * 要求用O(n)的时间复杂度，这个方法能过，但是不合规
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num > 0) {
                if (res == num) {
                    res++;
                } else if (res > num) {
                } else {
                    break;
                }
            }
        }
        return res;
    }


    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 1 && nums[i] <= n) {
                if (nums[i] != i+1) {
                    if (nums[i] == nums[nums[i] - 1]){
                        nums[i] = 0;
                    } else {
                      int t = nums[nums[i] - 1];
                      nums[nums[i] - 1] = nums[i];
                      nums[i] = t;
                      continue;
                    }
                }
            } else {
               nums[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1,1,2,2};

        System.out.println(new FirstMissingPositive().firstMissingPositive1(nums));
    }
}
