package org.spring.server.leetcode;

import java.util.*;
import java.util.Map.Entry;

/**
 * 找出数组中出现次数超过数组长度一半的数
 *
 */
public class FindMaxNumber {

    public int majorityElement(int[] nums) {
        int size = nums.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<size; i++){
            Integer count = map.get(nums[i]) == null?0:map.get(nums[i]);
            map.put(nums[i], count+1);
            if (map.get(nums[i]) > size/2){
                max = nums[i];
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        FindMaxNumber findMaxNumber = new FindMaxNumber();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findMaxNumber.moreCount(array));
    }

    /**
     * 摩尔计数法
     *  设定一个数，如果是这个数就+1， 不是这个数就-1
     *  因为要找的数一定多于一半，所以最后计算下来的vote一定是大于1 的，这个x就是结果
     * @param nums
     * @return
     */
    public int moreCount(int[] nums){
        int x = 0, vote = 0;
        for (int num: nums){
            if (vote == 0){
                x = num;
            }
            if (num == x){
                vote = vote +1;
            }else {
                vote = vote -1;
            }
        }
        return x;
    }
}
