package org.spring.server.leetcode.array;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * 提示：
 *
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestDifference {

    public int smallDifference(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < a.length && j < b.length;) {
            int abs = Math.abs(a[i] - b[j]);
            if (abs < 0) {
                abs = Integer.MAX_VALUE;
            }
            res = Math.min(res, abs);
            if (a[i] > b[j]) {
                j++;
            }else{
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-2147483648,1};
        int[] b =  {2147483647,0};

        System.out.println(new SmallestDifference().smallDifference(a, b));
    }
}
