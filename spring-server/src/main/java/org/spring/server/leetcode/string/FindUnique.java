package org.spring.server.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * @author Administrator
 */
public class FindUnique {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        if (s.length() == 1){
            return 0;
        }

        int length = s.length();
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i<length-1; i++){
            if (!judge(s, i, map)){
                return i;
            }
        }
        return -1;
    }

    private boolean judge(String s, int start, Map<Character, Boolean> map){
        int length = s.length();
        for (int j=length-1; j>start; j--){
            char x = s.charAt(start);
            if (!map.get(x)){
                if (x == s.charAt(j)){
                    map.put(x, true);
                    return true;
                }

            }

        }
        return false;
    }

    public static void main(String[] args) {
        String str = "aadadaad";
        FindUnique findUnique = new FindUnique();
        System.out.println(findUnique.firstUniqChar(str));
    }
}
