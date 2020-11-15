package org.spring.server.leetcode;

import java.util.Arrays;

/**
 * @author hitopei
 * 给你两个数组，arr1 和arr2，
 * <p>
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2中的元素arr2[i]各不相同
 * arr2 中的每个元素arr2[i]都出现在arr1中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            int value = arr2[i];
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == value) {
                    if (k == j) {
                        k++;
                    } else {
                        int tmp = arr1[j];
                        arr1[j] = arr1[k];
                        arr1[k] = tmp;
                        k++;
                    }
                }
            }
        }
        Arrays.sort(arr1, k, arr1.length);
        return arr1;
    }


}
