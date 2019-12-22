package org.spring.client.sort;

import java.util.Arrays;

/**
 * @author hitopei
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 6, 1, 3, 10, 32, 4, 0};
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.sort(array);
        Arrays.stream(result).forEach(e -> System.out.println(e));
    }

    public int[] sort(int[] array){

        if (array.length < 2){
            return array;
        }

        //找到中间点
        int middle = (int)Math.floor(array.length/2);
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right){
        //重新申请新的数组，用来存放排好序的数据
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0){
            if (left[0] <= right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
