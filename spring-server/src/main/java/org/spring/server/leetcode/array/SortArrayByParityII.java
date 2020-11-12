package org.spring.server.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hitopei
 *  给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : A) {
            if (num%2 == 0) {
                list2.add(num);
            } else {
                list1.add(num);
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i%2 == 0) {
                res[i] = list2.get(i/2);
            } else {
                res[i] = list1.get(i/2);
            }
        }
        return res;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int i = 0;
        for (int num : A) {
            if (num%2 == 0) {
                res[i] = num;
                i += 2;
            }
        }

        int j = 1;
        for (int num : A) {
            if (num%2 == 1) {
                res[j] = num;
                j += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII2(arr)));
    }
}
