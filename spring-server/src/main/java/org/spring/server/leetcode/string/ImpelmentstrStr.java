package org.spring.server.leetcode.string;

/**
 * @author hitopei
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class ImpelmentstrStr {
    public int strStr(String hayStack, String needle){
        if (needle.length() == 0) {
            return 0;
        }
        int length = needle.length();
        for (int i=0; i < hayStack.length() - length+1; i++){
            String subString = hayStack.substring(i, i+length);
            if (needle.equals(subString)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 双指针
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle){
        int nLen = needle.length();
        if (nLen == 0) {
            return 0;
        }

        int hLen = haystack.length();

        int l = 0;
        while (l < hLen - nLen + 1) {
            while (haystack.charAt(l) != needle.charAt(0)) {
                l++;
            }

            int currentLen = 0, pL = 0;
            while (pL < nLen && l < hLen && haystack.charAt(l) == needle.charAt(pL)) {
                ++l;
                ++pL;
                ++currentLen;
            }
            if (currentLen == nLen) {
                return l - nLen;
            }

            l = l - currentLen + 1;

        }

        return -1;
    }
    public static void main(String[] args) {
        String hayStack = "hell";
        String needle = "ll";
        System.out.println(new ImpelmentstrStr().strStr1(hayStack, needle));
    }
}
