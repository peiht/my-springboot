package org.spring.server.leetcode.hash;

/**
 * @author hitopei
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDifference {

    /**
     * 计数法
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 'a']++;
        }

        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            int index = chars1[i] - 'a';
            if (array[index] == 0) {
                return chars1[i];
            }
            array[index]--;
        }
        return chars1[t.length() - 1];
    }

    public char findTheDifference1(String s, String t){
        int countS = 0, countT = 0;
        for (char c : s.toCharArray()) {
            countS += c;
        }
        for (char c : t.toCharArray()){
            countT += c;
        }
        return (char) (countT - countS);
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("abcd", "abcde"));
    }
}
