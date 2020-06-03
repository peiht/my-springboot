package org.spring.server.leetcode;

/**
 * @author hitopei
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetSum {

    public int sumNums(int n) {
        int sum = n;
        //大于0就做右边的计算，妙啊
        boolean flag = n > 0 && (sum += sumNums(n - 1) ) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new GetSum().sumNums(4));
    }
}
