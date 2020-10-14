package org.spring.server.leetcode.array;

import java.util.HashMap;

/**
 * @author Administrator
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums){
        if (nums.length == 0) {
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = 0;
        for(int num:nums){
            if(!map.containsKey(num)){
                //左右记录改数字左右两侧出现的次数
                int left = map.get(num-1)==null?0:map.get(num-1);
                int right = map.get(num+1)==null?0:map.get(num+1);
                int cur = 1+left+right;
                if(cur>res){
                    res = cur;
                }
                map.put(num,cur);
                map.put(num-left,cur);
                map.put(num+right,cur);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutive().longestConsecutive(nums));

        System.out.println('中');
    }
}
