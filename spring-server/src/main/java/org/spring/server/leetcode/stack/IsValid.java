package org.spring.server.leetcode.stack;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s){
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }
            if (c == ']'){
                if (!stack.isEmpty()){
                    char cur = stack.pop();
                    if (cur != '['){
                        return false;
                    }
                }else {
                    return false;
                }
            }
            if (c == '}'){
                if (!stack.isEmpty()){
                    char cur = stack.pop();
                    if (cur != '{'){
                        return false;
                    }
                }else {
                    return false;
                }
            }
            if (c == ')'){
                if (!stack.isEmpty()){
                    char cur = stack.pop();
                    if (cur != '('){
                        return false;
                    }
                }else {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[";
        System.out.println(new IsValid().isValid(s));
    }
}
