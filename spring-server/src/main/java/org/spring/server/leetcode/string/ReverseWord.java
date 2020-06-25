package org.spring.server.leetcode.string;

/**
 * @author Administrator
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWord {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strings = s.split(" ");
        int length = strings.length;
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < strings[j].length(); i++) {
                sb.append(strings[j].charAt(i));
            }
            res.append(sb.reverse().toString()).append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new ReverseWord().reverseWords(s));
    }
}
