package org.spring.server.sort;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 快速排序
 */
public class QuickSort {

    /**
     * 双边循环法
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int[] quickSort(int[] nums, int start, int end) {
        if (start < end){
            int pivot = partition(start, end, nums);
            quickSort(nums,  start, pivot);
            quickSort(nums, pivot+1, end-1);
        }
        return nums;
    }

    int partition(int l, int r, int[] nums){
        //选取第一个作为基准
        int pivot = nums[l];
        int left = l, right = r;
        while (left != right) {
            if (left < right && nums[right] >= pivot){
                right--;
            }
            if (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(left, right, nums);
            }
        }
        nums[l] = nums[left];
        nums[left] = pivot;
        return left;
    }

    public void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 快速排序的另一种实现，单边循环法
     * @param nums
     * @return
     */
    public int[] quickSort1(int[] nums){
        int len = nums.length;

        for (int i = 0; i < len; i++) {

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8,3,5,4,6,9,2,7};
        int[] res = new QuickSort().quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(res));
    }
}
