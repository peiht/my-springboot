package org.spring.server.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = map.get(c);
            }
            map.put(c, j+1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])){
                count = 0;
                map.clear();
            }
            count++;
            map.put(chars[i], 1);

            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring1(s));
    }
}
