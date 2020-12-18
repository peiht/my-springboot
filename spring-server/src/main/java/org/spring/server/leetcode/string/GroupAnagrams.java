package org.spring.server.leetcode.string;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = String.copyValueOf(array);
            if (map.containsKey(s)) {
                LinkedList<String> list = map.get(s);
                list.addLast(str);
                map.put(s, list);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.addFirst(str);
                map.put(s, list);
            }
        }

        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> res = groupAnagrams.groupAnagrams(strs);
        System.out.println(res.toString());
        System.out.println(1);
    }
}
