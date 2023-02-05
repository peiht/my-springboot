package org.spring.server.leetcode.array;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums){
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        int[] nums = {2,1,5,0,4,6};
        System.out.println(increasingTriplet.increasingTriplet(nums));
    }
}
