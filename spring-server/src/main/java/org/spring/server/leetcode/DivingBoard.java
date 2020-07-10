package org.spring.server.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hitopei
 *
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            int longerNum = k - i;
            int res = (longerNum * longer) + (i * shorter);
            if (res != 0){
                set.add(res);
            }
        }
        int[] arr = new int[set.size()];
        int i = 0;
        if (!set.isEmpty()){
            for (int num : set) {
                arr[i] = num;
                i++;
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    public int[] divingBoard1(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer){
            return new int[]{longer * k};
        }

        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = longer * i + shorter * (k-i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new DivingBoard().divingBoard(2, 1118596, 979 );
        System.out.println(Arrays.toString(arr));
    }
}
