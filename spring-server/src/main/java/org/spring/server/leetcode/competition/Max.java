package org.spring.server.leetcode.competition;

/**
 * 5424.
 * @author hitopei
 */
public class Max {

    public int maxProduct(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int max = 0;
        for (int i=0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                max = Math.max(max, (nums[i] - 1)*(nums[j]-1));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,4,5};
        Max max = new Max();
        System.out.println(max.maxProduct(nums));
    }
}
