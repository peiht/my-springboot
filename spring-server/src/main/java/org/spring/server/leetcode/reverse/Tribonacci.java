package org.spring.server.leetcode.reverse;

/**
 * @author hitopei
 *
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Tribonacci {

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        return help(n, dp);
    }

    public int help(int n, int[] dp){
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
           return dp[n];
        } else {
            dp[n] = help(n-1, dp) + help(n-2, dp) + help(n-3, dp);
            return dp[n];
        }

    }



    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(2));
    }
}
