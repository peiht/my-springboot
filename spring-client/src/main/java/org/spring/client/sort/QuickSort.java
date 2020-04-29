package org.spring.client.sort;

import java.util.Arrays;

/**
 * @author hitopei
 *
 */
public class QuickSort {

    public int[] quick(int[] array, int left, int right){
        if(left < right){
            int partition = getPartition(array, left, right);
            quick(array, left, partition-1);
            quick(array, partition+1, right);
        }
        return array;
    }

    private int getPartition(int[] array, int left, int right){
        int pivot = left;
        int index = pivot+1;
        for(int i=index; i<= right; i++){
            if(array[i] < array[pivot]){
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index-1);
        return index-1;
    }

    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {5,4,7,8,9,32,8,3,8,1};
        int left = 0;
        int right = array.length-1;
        int[] result = quickSort.quick(array, left, right);
        Arrays.stream(result).forEach(e -> System.out.println(e));
    }

}
