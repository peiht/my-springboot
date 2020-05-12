package org.spring.server.leetcode;

/**
 * 递归训练
 * 反转字符串
 */
public class PracticeRecursion {

    public void reverseString(char[] s) {
        int len = s.length;
        //一个字符或者没有字符直接返回
        if(len <= 1){
            return;
        }else{
            re(s,0,len-1);
        }
    }
    //start指向交换的前部分，len指向交换的后部分
    public void re(char[] s,int start,int len){

        if(len-start>1){
            re(s,start+1,len-1);
        }
        char temp;
        temp = s[len];
        s[len]=s[start];
        s[start]=temp;
    }


    public static void main(String[] args) {
        PracticeRecursion practiceRecursion = new PracticeRecursion();
        char[] chars = {'1', '2', '3', '4'};
        practiceRecursion.reverseString(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}
