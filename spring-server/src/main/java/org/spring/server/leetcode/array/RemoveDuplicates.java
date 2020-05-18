package org.spring.server.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * bingo~
 *
 * @author hitopei
 *
 * 移除数组中重复的元素
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例：
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 *
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int pre = 0;
        for (int i=0; i< nums.length; i++){
            for (int j= i+1; j<nums.length; j++){
                int a = nums[j];
                int b = nums[pre];
                if (a > b){
                    nums[pre+1] = nums[j];
                    ++pre;
                }else {
                    i++;
                }
            }

        }
        return pre+1;
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }

}
