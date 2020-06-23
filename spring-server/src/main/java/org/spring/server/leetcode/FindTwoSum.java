package org.spring.server.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hitopei
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class FindTwoSum {

    /**
     * 原始做法，循环两边得出结果
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 1){
            return null;
        }
        int low = 0 , high = 0;
        for (int i=0; i<length; i++){
            for (int j=i+1; j< length; j++){
                if (target == nums[i]+nums[j]){
                    low = i;
                    high = j;
                    break;
                }
            }
        }
        int[] result = new int[2];
        result[0] = low;
        result[1] = high;
        return result;
    }

    /**
     * 优化， 使用hashmap优化查找复杂度
     * 记忆化存储
     */
    public int[] twoSum1(int[] sums, int target){
        int length = sums.length;
        if (length < 1){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< length; i++){
            int result = target - sums[i];
            if (map.containsKey(result)){
                return new int[] {map.get(result), i};
            }
            map.put(sums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        FindTwoSum findTwoSum = new FindTwoSum();
        int[] nums = {2, 2};
        //int[] result = findTwoSum.twoSum(nums, 4);
        int[] result = findTwoSum.twoSum1(nums, 4);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
