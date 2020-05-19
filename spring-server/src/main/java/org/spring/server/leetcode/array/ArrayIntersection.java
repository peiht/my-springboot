package org.spring.server.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 求数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author hitopei
 */
public class ArrayIntersection {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        //将数组1放置到map中，减少搜索次数
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                //2中出现的就放入1中，减少空间的使用
                nums1[k++] = n;
                //map中存在的，减少1
                m.put(n, cnt - 1);
            }
        }
        //截取数组中已经替换过的部分
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,5,6,7};
        int[] num2 = {3,4,5,9};

        ArrayIntersection arrayIntersection = new ArrayIntersection();
        int[] intersections = arrayIntersection.intersect(num1, num2);
        for (int intersection: intersections){
            System.out.println(intersection);
        }
    }
}
