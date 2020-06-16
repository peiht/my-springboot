package org.spring.server.leetcode.competition.doubleweek28;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hitopei
 *
 * 给你一个整数数组 arr 和一个整数值 target 。
 *
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 *
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,2,4,3], target = 3
 * 输出：2
 * 解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
 * 示例 2：
 *
 * 输入：arr = [7,3,4,7], target = 7
 * 输出：2
 * 解释：尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
 * 示例 3：
 *
 * 输入：arr = [4,3,2,6,2,3,4], target = 6
 * 输出：-1
 * 解释：我们只有一个和为 6 的子数组。
 * 示例 4：
 *
 * 输入：arr = [5,5,4,4,5], target = 3
 * 输出：-1
 * 解释：我们无法找到和为 3 的子数组。
 * 示例 5：
 *
 * 输入：arr = [3,1,1,1,5,1,2,1], target = 3
 * 输出：3
 * 解释：注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 1000
 * 1 <= target <= 10^8
 */
public class MinSumOfLengths {

    public int minSumOfLengths(int[] arr, int target) {
        int right = 0;
        int left = 0;
        int sum = 0;
        ArrayList<int[]> list = new ArrayList<>();

        // 求出所有符合要求的子数组
        while (right < arr.length) {
            sum += arr[right];
            right++;
            if (sum < target) {
                continue;
            }
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                list.add(new int[] { right - left, left });
            }
        }

        //结果按长度升序排序
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {

            //ans是两个长度之和，如果遍历到有超过这个长度的，后面的不是最小值无需遍历。
            int[] a = list.get(i);
            if (a[0] * 2 >= ans) {
                break;
            }
            for (int j = i + 1; j < list.size(); j++) {
                int arr1[] = list.get(i);
                int arr2[] = list.get(j);
                if (arr1[1] < arr2[1] && arr1[0] + arr1[1] > arr2[1]) {
                    continue;
                }
                if (arr2[1] < arr1[1] && arr2[0] + arr2[1] > arr1[1]) {
                    continue;
                }
                ans = Math.min(ans, arr1[0] + arr2[0]);

                //长度经过排序之后，后面的长度比当前大不满足最小，所以舍去不要进行遍历
                break;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,5,1,2,1};
        int target = 3;
        System.out.println(new MinSumOfLengths().minSumOfLengths(arr, target));
    }

}
