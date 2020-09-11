package org.spring.server.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hitopei
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {
    public List<List<Integer>> combine (int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k){
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(n, k, 1, deque, res);
        return res;
    }


    public void dfs(int n, int k, int begin, Deque<Integer> deque, List<List<Integer>> res){
        if (deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i <= n; i++) {
            deque.addLast(i);
            System.out.println("递归之前 => " + deque);
            dfs(n, k, i + 1, deque, res);
            deque.removeLast();
            System.out.println("递归之后 => " + deque);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Combine().combine(4, 2);
        System.out.println(res);
    }

}
