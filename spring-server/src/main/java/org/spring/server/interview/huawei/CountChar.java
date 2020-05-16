package org.spring.server.interview.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChar {

    public int getCount(String str, char target){
        int length = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=0; i< length; i++){
            char temp = str.charAt(i);
            if(target == temp){
                map.put(target, ++count);
            }
        }
        int result = map.get(Character.valueOf(target));
        return result;
    }

    public static void main(String[] args) {
        CountChar countChar = new CountChar();
        //System.out.println(countChar.getCount("ABCDEFG", 'A'));

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        Character c =  scanner.nextLine().charAt(0);
        System.out.println(countChar.getCount(str, c));
    }
}
