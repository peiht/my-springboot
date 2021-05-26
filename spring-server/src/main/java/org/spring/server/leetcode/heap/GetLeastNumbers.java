package org.spring.server.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int num : arr) {
            queue.offer(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 7, 4};
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(arr, 1)));
    }
}
