package org.spring.server.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hitopei
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSmaller {
    /**
     * 双循环 超时
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }

    /**
     * 二分查找?
     *  复杂度也很高
     *
     *  构建BST 不想写了
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = countBinary(nums, i+1, nums.length-1, nums[i]);
            res.add(count);
        }
        return res;
    }

    public int countBinary(int[] nums, int l, int r, int base){
        if (l == r) {
            if (nums[l] < base) {
                return 1;
            }
            return 0;
        }

        int index = l + (r-l)/2;
        return countBinary(nums, l, index, base) + countBinary(nums, index + 1, r, base);
    }

    public static void main(String[] args) {
        int[] nums = {5};
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> res = countSmaller.countSmaller1(nums);
        res.forEach(System.out::println);
    }


}
