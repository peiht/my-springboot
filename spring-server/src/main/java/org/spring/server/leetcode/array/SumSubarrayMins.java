package org.spring.server.leetcode.array;

import java.util.Stack;

/**
 * @author hitopei
 *
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *  
 *
 * 提示：
 *
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/teambition/x090lg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SumSubarrayMins {

    public int sumSubarrayMins(int[] A) {
        int mod = 1000000007;

        Stack<Pair> stack = new Stack<>();
        int ans = 0, dot = 0;

        for (int i = 0; i < A.length; i++){
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[i]) {
                Pair pair = stack.pop();
                count += pair.count;
                dot -= pair.val * pair.count;
            }
            stack.push(new Pair(count, A[i]));
            dot += A[i] * count;
            ans += dot;
            ans %= mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
        System.out.println(sumSubarrayMins.sumSubarrayMins(nums));
    }
}

class Pair {
    int count;
    int val;
    public Pair(int count, int val) {
        this.count = count;
        this.val = val;
    }
}
