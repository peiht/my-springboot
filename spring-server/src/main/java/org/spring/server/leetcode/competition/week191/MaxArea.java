package org.spring.server.leetcode.competition.week191;

import java.util.Arrays;

/**
 * 5425
 * @author hitopei
 */
public class MaxArea {

    //方法超时
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if (h == 0 || w == 0 || horizontalCuts.length == 0 || verticalCuts.length == 0){
            return 0;
        }

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] heightResult = this.getResult(h, horizontalCuts);
        int[] widthResult = this.getResult(w, verticalCuts);

        int max = 0;
        for (int height: heightResult){
            for (int width: widthResult){
                max = Math.max(max, height*width);
            }
        }

        int mod = 10^9 +7;
        return max%mod;
    }

    public int[] getResult(int a, int[] pre){
        int[] little = new int[pre.length + 1];

        for (int i=0; i < pre.length; i++){
            if (i == 0){
                little[i] = pre[i];
            } else {
                little[i] = pre[i] - pre[i-1];
            }
        }
        little[pre.length] = a - pre[pre.length-1];
        return little;
    }

    public static void main(String[] args) {
        int h = 5;
        int w = 4;
        int[] horizontalCuts  =  {3,1};
        int[] verticalCuts = {1};
        System.out.println(new MaxArea().maxArea(h, w, horizontalCuts, verticalCuts));
    }
}
