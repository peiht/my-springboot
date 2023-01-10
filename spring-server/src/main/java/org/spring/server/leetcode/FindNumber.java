package org.spring.server.leetcode;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 *
 * 示例：
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * @author hitopei
 */
public class FindNumber {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0, end = nums.length-1;

        int mid;
        while (start <= end ){
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    /**
     * 找超出边界点，在查找
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            if (nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        int index = 0;
        for (int i=0; i< nums.length-1; i++){
            int pre = nums[i];
            int next = nums[i+1];
            if (pre > next){
                index = next;
                break;
            }
        }
        int result = binarySearch(Arrays.copyOfRange(nums, 0, index), target);
        if (result != -1){
            return result;
        }
        int result1 = binarySearch(Arrays.copyOfRange(nums, index, nums.length), target);
        if (result1 != -1){
            return result1+index;
        }
        return -1;
    }

    public int binarySearch(int[] array, int target){
        if (array.length == 1){
            if (array[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        int start = 0;
        int end = array.length -1;
        while (start <= end){
            int mid = (start + end)/2;
            if (target == array[mid]) {
                return mid;
            }else if (target < array[mid]){
                end = mid -1;
            }else if (target > array[mid]){
                start = mid +1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindNumber findNumber = new FindNumber();
        int[] array = {4,5,6,7,0,1,2};
        System.out.println(findNumber.search(array, 1));
    }


}
