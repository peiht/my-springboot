package org.spring.server.interview.tecnent;

import java.util.*;

public class MaxCount {

    /**
     * leetCode超时
     * @param array
     * @return
     */
    public int maxCount(int[] array){
        if (array.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<array.length; i++){
            for (int j=i; j<array.length;j++){
                int[] arrayNew = Arrays.copyOfRange(array, i,j+1);
                int result = Arrays.stream(arrayNew).sum();
                if (result > max){
                    max = result;
                }
            }
        }
        return max;
    }

    public int maxCount1(int[] array){
        if (array.length == 0){
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<array.length; i++){
            int num = array[i];
            if (num < 0){
                list.add(i);
            }
        }

        if (list.size() ==0){
            return Arrays.stream(array).sum();
        }

        int max = 0;
        int start = 0;
        for (int index : list){
            int[] arrayNew = Arrays.copyOfRange(array, start,index);
            int result = Arrays.stream(arrayNew).sum();
            if (result > max){
                max = result;
            }
            start = index+1;
        }
        return max;
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int maxCount2(int[] nums){
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        MaxCount maxCount = new MaxCount();
        System.out.println(maxCount.maxCount2(array));
    }
}
