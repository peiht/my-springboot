package org.spring.server.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hitopei
 *
 *给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {
    //居然超时了 !n 时间复杂度高
    public boolean checkInclusion(String s1, String s2){
        if (s1.length() == 0) {
            return true;
        }

        //求出s1所有的排列，放入set，在从s2求字符串去匹配
        char[] chars = s1.toCharArray();
        int len = chars.length;
        Set<String> set = permutation(s1);
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            String subString = s2.substring(i, i + s1.length());
            if (set.contains(subString)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> permutation(String str) {
        Set<String> ans=new HashSet<>();
        //所有排列的可能都在这里
        if(str!=null||str.length()>0){
            help(0,str.toCharArray(),ans);
        }

        return ans;
    }
    public static void help(int i,char[] cha, Set<String> ans){
        if(i==cha.length-1){
            String val = String.valueOf(cha);
            if(!ans.contains(val)){
                ans.add(val);
            }
        }else{
            for(int j=i;j<cha.length;j++){
                swap(i,j,cha);//依次选一个数固定住
                help(i+1,cha,ans);//让后面的进行全排列
                swap(i,j,cha);//恢复原来的模样，回溯关键
            }
        }

    }
    public static void swap(int i,int j,char[] cha){
        char temp=cha[i];
        cha[i]=cha[j];
        cha[j]=temp;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(new CheckInclusion().checkInclusion(s1, s2));
    }
}
