package org.spring.server.leetcode.dp;

/**
 * @author hitopei
 *  给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubsequence {

    /**
     * 子序列不等于子串， 所以不是字符串匹配问题
     *
     * s和t搞反了，不想换了
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return false;
        }

        int m = s.length(), n = t.length();
        int start = 0, end = 0;

        while (start < m && end < n){
            char ct = t.charAt(end);
            char cs = s.charAt(start);
            if (cs != ct){
                start++;
            }
            if (cs == ct){
                start++;
                end++;
            }
        }

        return end == m;
    }

    /**
     * dp解决问题
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t){
        int sl = s.length(), tl = t.length();
        if (sl > tl) {
            return false;
        }
        if (sl == 0) {
            return true;
        }
        boolean[][] dp = new boolean[sl+1][tl+1];
        for (int i = 0; i < tl; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= sl ; i++) {
            for (int j = 1; j <= tl; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[sl][tl];
    }

    public static void main(String[] args) {
        String s = "djk";
        String t = "cbdskjkdjsk";
        System.out.println(new IsSubsequence().isSubsequence1(s, t));
    }
}
