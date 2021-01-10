package org.spring.server.leetcode.heap;

import java.util.PriorityQueue;

/**
 * create by hitopei on 2020/12/30 10:28 上午
 * @author hitopei
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones){
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int stone : stones){
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            queue.add(s1 - s2);
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
    }
}
