package org.spring.server.leetcode.reverse;

/**
 * @author hitopei
 * 兑换零钱问题，用dp思想
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount){
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }


    private int coinChange(int[] coins, int rem, int[] count){
        if (rem < 0) {
            return -1;
        }
        if (rem == 0){
            return 0;
        }

        if (count[rem-1] != 0){
            return count[rem-1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < rem) {
                min = 1 + res;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }


    public static void main(String[] args) {
        int[] nums = {1,2,5};

        System.out.println(new CoinChange().coinChange(nums, 11));
    }
}
