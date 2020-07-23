package org.spring.server.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author hitopei
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class NumSquares {
    public int numSquares(int n){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(0);
        set.add(0);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j * j + cur <= n; j++) {
                    int next = j * j + cur;
                    if (next == n) {
                        return res;
                    }
                    if (next < n && !set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new NumSquares().numSquares(11);
        System.out.println(res);
    }
}
