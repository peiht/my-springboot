package org.spring.server.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hitopei
 *
 * 堆内存溢出示意
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add("1");
        }


    }
}
