package org.spring.server.leetcode.string;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开
 * 例如：
 * 输入 hello world
 * 输出 5
 */
public class FindLastLength {

    /**
     * 最笨的方法
     * @param str
     * @return
     */
    public int getLength(String str){
        if (str == null){
            return 0;
        }
        str.trim();
        String[] array = str.split(" ");
        if(array.length > 0){
            String last = array[array.length-1];
            return last.length();
        }
        return 0;
    }

    /**
     * 直接搜寻字符串的最后一个空格的索引
     * @param s
     * @return
     */
    public int getLength2(String s){
        s = s.trim();
        int index = s.lastIndexOf(" ") + 1;
        String str = s.substring(index);
        return str.length();
    }



    public static void main(String[] args) {
        FindLastLength findLastLength = new FindLastLength();
        System.out.println(findLastLength.getLength2(" "));
    }
}
