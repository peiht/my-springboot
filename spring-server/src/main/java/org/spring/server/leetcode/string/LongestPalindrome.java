package org.spring.server.leetcode.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/longest-palindromic-substring">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hitopei
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++){
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i+1));
            if (cur > len){
                len = cur;
                start = i-(cur-1)/2;
            }
        }
        return s.substring(start, start+len);
    }

    private int getLen(String s, int l, int r){
        while (l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            --l;
            ++r;
        }
        return r-l-1;
    }

    /**
     *
     *暴力破解法
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i=0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "asddsaa";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
}
