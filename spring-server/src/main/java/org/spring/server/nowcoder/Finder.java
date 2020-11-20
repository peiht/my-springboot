package org.spring.server.nowcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : a) {
            queue.add(num);
        }

        for (int i = 0; i < K; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};
        System.out.println(new Finder().findKth(a, 5, 3));
    }
}
