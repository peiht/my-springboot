package org.spring.server.leetcode.competition;

import java.util.HashSet;
import java.util.Set;

/**
 * 5426
 * @author hitopei
 */
public class ChangeRoute {

    public int minReorder(int n, int[][] connections) {
        Set<Integer> available = new HashSet<>();
        available.add(0);
        int change = 0;
        for (int[] line : connections) {
            if (available.contains(line[1])){
                available.add(line[0]);
            } else {
                change++;
                available.add(line[1]);
            }
        }
        return change;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1},{2,0}, {3,2}};
        System.out.println(new ChangeRoute().minReorder(n, connections));
    }
}
