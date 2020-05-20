package org.spring.server.leetcode;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hitopei
 */
public class FindMaxSubString {

    public int findTheLongestSubstring(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[32];
        int cur = 0;
        Arrays.fill(dp, n);
        dp[0] = -1;
        for(int i = 0 ; i < n ; i++){
            int id = getIndex(s.charAt(i));
            if(id >= 0) {
                cur ^= (1 << id);
            }
            dp[cur] = Math.min(dp[cur], i);
            res = Math.max(res, i - dp[cur]);
        }
        return res;
    }

    private int getIndex(char c){
        if(c == 'a'){
            return 0;
        } else if(c == 'e'){
            return 1;
        } else if(c == 'i'){
            return 2;
        } else if(c == 'o'){
            return 3;
        } else if(c == 'u'){
            return 4;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        FindMaxSubString findMaxSubString = new FindMaxSubString();
        String str = "eleetminicoworoep";
        System.out.println(findMaxSubString.findTheLongestSubstring(str));
    }
}
