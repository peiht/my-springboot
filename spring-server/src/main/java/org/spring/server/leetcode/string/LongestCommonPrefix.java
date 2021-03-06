package org.spring.server.leetcode.string;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0){
            return "";
        }
        int index = 1;
        if ("".equals(strs[0])){
            return "";
        }
        String sub = strs[0].substring(0, index);
        while (find(strs, sub)){
            index++;
            if (index > strs[0].length()){
                break;
            }
            sub = strs[0].substring(0, index);
        }
        return sub.substring(0, index-1);
    }

    private boolean find(String[] strs, String sub){
        int length = sub.length();
        for (String s : strs) {
            if (s.length() < sub.length()){
                return false;
            }
            if (!sub.equals(s.substring(0, length))) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String reg = strs[0];
        for (String str : strs) {
            while (!str.startsWith(reg)) {
                //从后往前截取，截取到最后如果还没有完全匹配，则说明没有公共前缀
                if (reg.length() == 1) {
                    return "";
                }
                reg = reg.substring(0, reg.length()-1);
            }
        }
        return reg;
    }

    public static void main(String[] args) {
        String[] strs = {"a","as","ad"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
