package org.spring.client.sort;

import java.util.Arrays;

/**
 * @author hitopei
 *
 */
public class ChooseSort {

    public static void main(String[] args) {

        int[] array = {4,2,5,3,6,1};
        ChooseSort chooseSort = new ChooseSort();
        int[] result = chooseSort.sort(array);
        Arrays.stream(result).forEach(e -> System.out.println(e));
    }

    public int[] sort(int[] array){

        for (int i=1; i<array.length; i++){
            //要排序的单独提取出来
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }

            if (j != i){
                array[j] = temp;
            }
        }
        return array;
    }
}
