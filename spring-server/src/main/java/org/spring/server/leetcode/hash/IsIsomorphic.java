package org.spring.server.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hitopei
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsIsomorphic {

    //这方法也太笨了
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s, t) && isIsomorphic1(t, s);
    }

    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.containsKey(c)) {
                map.putIfAbsent(i, set.get(c));
            }else {
                map.putIfAbsent(i, i);
                set.put(c, i);
            }
        }

        Map<Integer, Character> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char tc = t.charAt(i);
            if (map.get(i) != i) {
                if (tc != map1.get(map.get(i))){
                    return false;
                }
            } else {
                map1.put(i, tc);
            }
        }
        return true;
    }


    public boolean isIsomorphic2(String s, String t){
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String s = "aa";
        String t = "ab";
        System.out.println(new IsIsomorphic().isIsomorphic(t, s));
    }
}
