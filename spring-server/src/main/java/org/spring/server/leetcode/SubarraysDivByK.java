package org.spring.server.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hitopei
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int a : A){
            sum += a;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = map.getOrDefault(modulus, 0);
            ans += same;
            map.put(modulus, same + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraysDivByK subarraysDivByK = new SubarraysDivByK();
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;
        System.out.println(subarraysDivByK.subarraysDivByK(A , K));
    }
}
