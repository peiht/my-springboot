package org.spring.server.leetcode.array;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumCloset {

    public int threeSumCloset(int[] nums, int target){
        //排序
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if (sum < target) {
                    start++;
                }else if (sum > target){
                    end--;
                }else {
                    return target;
                }
            }
        }


       return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(new ThreeSumCloset().threeSumCloset(nums, target));
    }
}
