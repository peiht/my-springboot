package org.spring.server.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hitopei
 *
 *
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, combine, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int index){
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            res.add(combine);
            return;
        }

        if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, combine, ++i);
                combine.remove(combine.size() - 1);
            }

        }

    }

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = new CombinationSum2().combinationSum2(candidates, target);
        System.out.println(res);
    }
}
