package org.spring.server.leetcode.competition.doubleweek30;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 *
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 *
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 *
 * 示例 1：
 *
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * 示例 2：
 *
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * 示例 3：
 *
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 */
public class ReformatDate {

    public String reformatDate(String date) {
        if (date == null || date.length() == 0) {
            return "";
        }

        String[] arr = date.split(" ");

        Map<String, String> dayMap = new HashMap<>();
        dayMap.put("1st", "01");
        dayMap.put("2nd", "02");
        dayMap.put("3rd", "03");
        dayMap.put("4th", "04");
        dayMap.put("5th", "05");
        dayMap.put("6th", "06");
        dayMap.put("7th", "07");
        dayMap.put("8th", "08");
        dayMap.put("9th", "09");
        dayMap.put("10th", "20");
        dayMap.put("11st", "11");
        dayMap.put("12nd", "12");
        dayMap.put("13rd", "13");
        dayMap.put("14th", "14");
        dayMap.put("15th", "15");
        dayMap.put("16th", "16");
        dayMap.put("17th", "17");
        dayMap.put("18th", "18");
        dayMap.put("19th", "19");
        dayMap.put("20th", "20");
        dayMap.put("21st", "21");
        dayMap.put("22nd", "22");
        dayMap.put("23rd", "23");
        dayMap.put("24th", "24");
        dayMap.put("25th", "25");
        dayMap.put("26th", "26");
        dayMap.put("27th", "27");
        dayMap.put("28th", "28");
        dayMap.put("29th", "29");
        dayMap.put("30th", "30");
        dayMap.put("31st", "31");

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        StringBuilder sb = new StringBuilder();
        sb.append(arr[2]).append("-").append(monthMap.get(arr[1])).append("-").append(dayMap.get(arr[1]));
        return sb.toString();
    }


}
