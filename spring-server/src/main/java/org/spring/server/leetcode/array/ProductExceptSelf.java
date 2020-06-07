package org.spring.server.leetcode.array;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductExceptSelf {

    /**
     * 执行超时了 ，不可取
     * @param nums
     * @return
     */
    public int[] productExpectSelf(int[] nums){
        int[] output = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int[] left = Arrays.copyOfRange(nums, 0,i);
            int[] right = Arrays.copyOfRange(nums, i+1, nums.length);
            output[i] = getResult(left) * getResult(right);
        }
        return output;
    }

    private int getResult(int[] array){
        int result=1;
        for (int i: array) {
            result = i * result;
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] multi = new int[nums.length];
        int left = 1, right = 1, n = nums.length;
        Arrays.fill(multi, 1);
        for (int i = 0; i < n; i++) {
            //求前缀乘积
            multi[i] *= left;
            left *= nums[i];

            //求后缀乘积
            multi[n - i - 1] *= right;
            right *= nums[n - i - 1];
        }
        return multi;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(nums)));
    }
}
