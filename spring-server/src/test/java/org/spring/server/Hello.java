package org.spring.server;

public class Hello {

    public int sum(int a, int b, int c){
        int d = a + b;
        int e = d * c;
        int f = a - b;
        int g = e/f;
        return g;
    }

    public static void main(String[] args) {
        System.out.println(new Hello().sum(1, 2, 3));
    }
}
