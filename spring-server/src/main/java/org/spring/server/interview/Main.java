package org.spring.server.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

//        int[] nums = {3, 9, 16 , 20 };
//        int hours = 8;
//        System.out.println(11%8);
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()){
            int i = in.nextInt();
            list.add(i);
        }

        int hours = list.get(list.size()-1);
        list.remove(list.size()-1);
        Integer[] sums = new Integer[list.size()-1];

        Main main = new Main();
        //System.out.println(main.getMinSpeed(hours, nums));
    }

    public int getMinSpeed(int hours, int[] nums){
        if (hours <=0){
            return -1;
        }

        if (nums == null || nums.length == 0){
            return -1;
        }
        int count = Arrays.stream(nums).sum();
        int average = count/hours ;
        int spend = 0;
        while (spend < hours){
            for (int num: nums){
                if (num%average == 0){
                    spend = spend + num/average;
                }else {
                    spend = spend + num/average + 1;
                }
            }
            average++;
        }

        return average;
    }


    public int getCostTime(int m, int n, int[] time){
        Arrays.sort(time);
        List<Integer>[] array = new List[m];
        int per = 0;
        //如果处理器数量大于任务数量，取最耗时的任务时间
        if (m > n){
            return time[time.length-1];
        }

        for (List<Integer> list: array){
            list.add(time[per]);
            per++;
        }



        return -1;
    }
}
