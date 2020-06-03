package org.spring.server.leetcode.string;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)){
            return true;
        }

        int i=0;
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(i)) {
                if (i+2 > s.length()){
                    String subString1 = s.substring(i, i+1);
                    String subString2 = t.substring(i, i+1);
                    if (!subString1.equals(subString2)){
                        return false;
                    }
                }else {
                    String subString1 = s.substring(i, i+2);
                    String subString2 = t.substring(i, i+2);
                    if (subString1.charAt(0) == subString2.charAt(1) && subString1.charAt(1) == subString2.charAt(0)) {
                        i = i+2;
                    }else {
                        return false;
                    }
                }
            }else {
                i = i+1;
            }
        }

        return true;
    }

    /**
     * 异位是字符数相同不是两两相反，理解错了
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }
    public static void main(String[] args) {
        String s = "";
        String t = "";
        System.out.println(new IsAnagram().isAnagram(s, t));
    }


}
