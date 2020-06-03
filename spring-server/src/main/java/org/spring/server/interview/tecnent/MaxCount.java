package org.spring.server.interview.tecnent;

import java.util.*;

public class MaxCount {

    public int maxCount(int[] array){
        if (array.length == 0){
            return 0;
        }

        int max = 0;
        for (int i=0; i<array.length; i++){
            for (int j=i; j<array.length;j++){
                int[] arrayNew = Arrays.copyOfRange(array, i,j+1);
                int result = Arrays.stream(arrayNew).sum();
                if (result > max){
                    max = result;
                }
            }
        }
        return max;
    }

    public int maxCount1(int[] array){
        if (array.length == 0){
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<array.length; i++){
            int num = array[i];
            if (num < 0){
                list.add(i);
            }
        }

        if (list.size() ==0){
            return Arrays.stream(array).sum();
        }

        int max = 0;
        int start = 0;
        for (int index : list){
            int[] arrayNew = Arrays.copyOfRange(array, start,index);
            int result = Arrays.stream(arrayNew).sum();
            if (result > max){
                max = result;
            }
            start = index+1;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {1, 4, -5, 9, 8, 3, -6};
        MaxCount maxCount = new MaxCount();
        System.out.println(maxCount.maxCount1(array));
    }
}
