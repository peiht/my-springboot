package org.spring.server.leetcode.map;

import java.util.*;

public class AlterNames {

    public List<String> alterNames(String[] keyName, String[] keyTime){
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(keyName[i], new ArrayList<>());

            int hour = (time.charAt(0) - '0')*10 + (time.charAt(1)-'0');
            int minute = (time.charAt(3) - '0')*10 + (time.charAt(4)-'0');
            map.get(name).add(hour*60 + minute);
        }

        List<String> nameRes = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> time = map.get(name);
            Collections.sort(time);
            for (int i = 2; i < time.size(); i++) {
                int time1 = time.get(i - 2), time2 = time.get(i);
                if ((time2 - time1) <= 60) {
                    nameRes.add(name);
                    break;
                }
            }


        }
        Collections.sort(nameRes);
        return nameRes;
    }

    public static void main(String[] args) {
        String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        List<String> nameList = new AlterNames().alterNames(keyName, keyTime);
        System.out.println(nameList);
    }
}
