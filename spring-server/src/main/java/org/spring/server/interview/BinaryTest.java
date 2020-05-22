package org.spring.server.interview;

/**
 * 二进制运算符
 *
 * & 与运算 。两者都为1则为1，否则为0
 * | 或运算 。有1就是1 ，都是0才为0
 * ~ 非运算 。1为0 0为1
 * ^ 异或运算 。两者相等为0 不相等为1
 */
public class BinaryTest {

    /**
     * 不用 + - * / 计算两数字之和
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        //1100
        int a = 12;
        //1111
        int b = 15;
        //0011
        int c = a ^ b;
        //1100
        int d = a & b;
        //11000
        int e = d << 1;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        BinaryTest binaryTest = new BinaryTest();
        System.out.println(binaryTest.add(30, 19));

        System.out.println(1 << Integer.SIZE - 3);
    }
}
