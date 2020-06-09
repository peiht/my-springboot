package org.spring.server.leetcode;

/**
 * @author hitopei
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {

    public int translateNum (int num) {
        //转换成字符串
        String s = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < s.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = s.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    public int translateNum1(int num) {
        //将字符串转化为数字
        String str = String.valueOf(num);
        //dfs遍历字符串求解
        return dfs(str, 0);
    }
    //表示从index位置开始有好多种翻译方法
    public int dfs(String str, int index){
        //如果当前的下标大于等于字符串的长度 - 1，则说明当前位置是由上一次跳到此处的，则直接返回1
        if(index >= str.length() - 1) {
            return 1;
        }
        //先求解每一次都翻译一个字符的方法数
        int res = dfs(str, index + 1);
        //以当前字符的下标为开始，截取两位，判断这位组成的数字是否在10~25之间
        //如果在这一次就可以直接翻译两个字符，然后从两个字符后面的位置开始翻译
        String temp = str.substring(index, index + 2);
        if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
            res += dfs(str, index + 2);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(new TranslateNum().translateNum(num));
    }
}
