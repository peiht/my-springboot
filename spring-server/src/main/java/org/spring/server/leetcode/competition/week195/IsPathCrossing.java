package org.spring.server.leetcode.competition.week195;

/**
 * @author hitopei
 *
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * 示例 2：
 *
 *
 *
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 */
public class IsPathCrossing {
    public boolean isPathCrossing(String path) {
        if (path == null || "".equals(path)){
            return false;
        }

        char[] chars = path.toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == 'W'){
                arr[i] = 1;
            }
            if (chars[i] == 'E'){
                arr[i] = -1;
            }
            if (chars[i] == 'S'){
                arr[i] = 2;
            }
            if (chars[i] == 'N'){
                arr[i] = -2;
            }
        }


        int[] sum = new int[arr.length + 1];
        sum[0] = 0;
        for (int i=0; i< arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (sum[i] - sum[j] == 0 && i != j) {
                    return true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String s = "WSSESEEE";
        System.out.println(new IsPathCrossing().isPathCrossing(s));
    }
}
