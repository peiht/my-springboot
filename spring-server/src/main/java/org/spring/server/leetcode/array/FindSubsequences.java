package org.spring.server.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hitopei
 *
 *
 */
public class FindSubsequences {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequence(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums){
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(new FindSubsequences().findSubsequence(nums));
        Integer.bitCount(1);
    }

}
