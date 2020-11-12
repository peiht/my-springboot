package org.spring.server.datastruct.list;

import java.util.List;

public class TestList {

    public static void main(String[] args) {
        List<String> arrayListDemo = new ArrayListDemo<>();
        arrayListDemo.add("1");
        arrayListDemo.add("2");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        arrayListDemo.add("3");
        System.out.println(arrayListDemo.contains("1"));
        System.out.println(arrayListDemo);
    }

}
