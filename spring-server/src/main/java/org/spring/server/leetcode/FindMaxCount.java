package org.spring.server.leetcode;

/**
 * @author Administrator
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 例如:
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 *  则最大结果就是5
 */
public class FindMaxCount {

    public int maxScore(String s){
        int max = 0;
        for (int i = 1; i < s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            int count = this.count(left, 0) + this.count(right, 1);
            if (max <= count){
                max = count;
            }
        }
        return max;
    }

    private int count(String s, int type){
        int length = s.length();
        int count = 0;
        for (int i = 0; i< length; i++){
            String number = s.substring(i, i+1);
            Integer a = Integer.valueOf(number);
            if (type == 0){
                if (a == 0){
                    count++;
                }
            } else {
                if (a == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindMaxCount findMaxCount = new FindMaxCount();
        int max = findMaxCount.maxScore("011101");
        System.out.println(max);
    }
}
