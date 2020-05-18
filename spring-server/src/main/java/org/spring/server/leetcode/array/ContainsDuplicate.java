package org.spring.server.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @author hitopei
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){
        if (nums.length == 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums ){

            if (set.contains(num)){
                return true;
            }else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }
}
