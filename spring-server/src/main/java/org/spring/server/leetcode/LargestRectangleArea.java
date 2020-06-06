package org.spring.server.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Administrator
 * 求最大矩形面积
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleArea {

    /**
     * 方法一
     *
     * 左边看一下，看最多能向左延伸多长，找到大于等于当前柱形高度的最左边元素的下标；
     *
     * 右边看一下，看最多能向右延伸多长；找到大于等于当前柱形高度的最右边元素的下标。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights){
        if (heights.length == 0){
            return 0;
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {

            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }

    //维护一个单调递增的栈，如果有比当前高度小的就把前面的pop，计算其最大的值。
    public int largestRectangleArea1(int[] heights){
        int[] temp = new int[heights.length+2];
        System.arraycopy(heights, 0, temp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i=0; i<temp.length; i++){
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]){
                int h = temp[stack.pop()];
                area = Math.max(area, h*(i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return area;
    }



    public static void main(String[] args) {

        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea.largestRectangleArea1(nums));
    }
}
