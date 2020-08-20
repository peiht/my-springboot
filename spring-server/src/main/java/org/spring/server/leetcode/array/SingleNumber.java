package org.spring.server.leetcode.array;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * @author hitopei
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<length; i++){
            int value = nums[i];
            int cos =0;
            if(map.get(value) != null){
                cos = map.get(value);
            }
            map.put(value, cos+1);
        }

        List<Integer> list = new ArrayList();

        map.forEach((k ,v) ->{
            if(v == 1){
                list.add(k);
            }
        });


        return list.get(0);
    }

    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        int res = 0;
        while (iterator.hasNext()) {
            res = iterator.next();
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int[] nums1 = {4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber1(nums));
        System.out.println(singleNumber.singleNumber1(nums1));
    }
}
