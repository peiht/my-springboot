package org.spring.server.leetcode.string;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hitopei
 *
 *给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorganizeString {
    public String reorganizeString(String S){
        if (S.length() < 2){
            return S;
        }

        int[] counts = new int[26];
        int maxCount = 0;
        int len = S.length();
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (len + 1)/2) {
            return "";
        }
        Queue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0){
                queue.offer(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            stringBuilder.append(letter1).append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0){
                queue.offer(letter1);
            }
            if (counts[index2] > 0){
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0){
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }
}
