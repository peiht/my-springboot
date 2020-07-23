package org.spring.server.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hitopei
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i=0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperaturesStack(int[] T){
        int length = T.length;
        int[] result = new int[length];
        Queue<Integer> stack = new LinkedList<>();

        for (int i =0; i < length; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.poll();
                result[idx] = i - idx;
            }
            stack.add(i);
        }
        return result;
    }

    public int[] dailyTemperature(int[] T){
        int length = T.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(length-1);
        for (int i = length-2; i >= 0 ; i--) {
            if (!stack.isEmpty()) {
                int cur = stack.peek();
                if (T[i] > cur) {
                    stack.push(i);
                }else {

                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperaturesStack(T)));
    }
}
