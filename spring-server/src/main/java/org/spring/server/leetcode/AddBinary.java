package org.spring.server.leetcode;

/**
 * @author hitopei
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int ca = 0;
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            stringBuilder.append(sum % 2);
            ca = sum / 2;
        }
        stringBuilder.append(ca == 1 ? ca : "");
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "1";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}
