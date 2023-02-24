package org.spring.server.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BestHands {

    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int rank : ranks) {
            int num = numMap.getOrDefault(rank, 0);
            numMap.put(rank, num + 1);
        }

        Set<Character> strSet = new HashSet<>();
        for (Character suit : suits) {
            strSet.add(suit);
        }

        if (strSet.size() == 1) {
            return "Flush";
        }


        if (numMap.size() == 5) {
            return "High Card";
        }

        if (numMap.size() == 2) {
            return "Three of a kind";
        }
        if (numMap.size() == 3) {
            for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
                if (entry.getValue() == 3){
                    return "Three of a kind";
                }
            }
        }
        return "Pair";

    }

    public static void main(String[] args) {

    }
}
