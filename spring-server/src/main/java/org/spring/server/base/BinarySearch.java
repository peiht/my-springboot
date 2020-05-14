package org.spring.server.base;

/**
 * 二分查找训练
 * @author Administrator
 */
public class BinarySearch {

    /**
     * 循环查找
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int target){
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

    /**
     * 递归实现
     * @param array
     * @param length
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int length, int target){
        return binarySearchInternally(array, 0, length -1, target);
    }

    private static int binarySearchInternally(int[] array, int low, int high, int target){
        int mid = (high + low) / 2;
        if (array[mid] == target){
            return mid;
        }else if (array[mid] > target){
            return binarySearchInternally(array, low, mid-1, target);
        }else {
            return binarySearchInternally(array, mid+1, high, target);
        }
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        //System.out.println(BinarySearch.binarySearch(array, 9));
        System.out.println(BinarySearch.binarySearch(array, array.length, 8));
    }
}
