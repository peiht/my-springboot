package org.spring.server.base;

/**
 * @author hitopei
 */
public class QuickSort {

    public int[] quickSort(int[] nums, int left, int right){
        if (left < right) {
            int pivot = getPartition(nums, 0, nums.length);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
        return nums;
    }

    public int getPartition(int[] nums, int left, int right){
        int pivot = left, index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[pivot] > nums[i]) {
                swap(nums, i, pivot);
                index++;
            }
        }
        swap(nums, index - 1, pivot);
        return pivot;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {};
    }
}
