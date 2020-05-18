package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 */
public class SellShare {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1){
            return 0;
        }
        int profit = 0;
        int start = 0;
        int end = 1;
        //两个指针，一个负责找区间内最小值，一个找最高值
        for (int i=0; i<prices.length; i++){
            if (prices[i] >= prices[i + 1]) {
                ++start;
            }
            ++end;
        }
        return profit;
    }

    /**
     * 直接找差价获取。。。。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        SellShare sellShare = new SellShare();
        System.out.println(sellShare.maxProfit(prices));

    }
}
