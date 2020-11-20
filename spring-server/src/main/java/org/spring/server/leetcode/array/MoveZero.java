package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 0,1,0,3,12 -> 1,0,0,3,12 -> 1,0,0,3,12 -> 1,0,3,0,12 -> 1,0,3,12,0
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class MoveZero {

    public void moveZeroes(int[] nums) {
        if (nums.length  == 0){
            return;
        }
        int notZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap( notZero, i, nums);
                notZero++;
            }
        }
//        int count = 0;
//        int end = nums.length-count;
//        for (int i = 0; i < end; i++) {
//            int j = i;
//            int num = nums[j];
//            if (num != 0) {
//                swap(j, j + 1, nums);
//                count = count + 1;
//
//            }
//
//        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    public void moveZero(int[] nums){
        int len = nums.length, index = 0;

        for(int i = 0; i < len; i++){
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] nums = {0,0,1, 34,5,6,7};
        //moveZero.moveZeroes(nums);
        moveZero.moveZero(nums);

        for (int num : nums){
            System.out.println(num);
        }
    }
}
