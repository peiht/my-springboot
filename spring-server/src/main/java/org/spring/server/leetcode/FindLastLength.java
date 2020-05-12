package org.spring.server.leetcode;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开
 * 例如：
 * 输入 hello world
 * 输出 5
 */
public class FindLastLength {

    public int getLength(String str){
        if (str == null){
            return 0;
        }
        String[] array = str.split(" ");
        String last = array[array.length-1];
        return last.length();
    }
    public static void main(String[] args) {
    }
}
