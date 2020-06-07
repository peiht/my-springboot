package org.spring.server.leetcode.array;

import java.util.Arrays;

/**
 * @author hitopei
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix){
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            // left to right.
            for(int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if(++t > b) {
                break;
            }
            // top to bottom.
            for(int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if(l > --r) {
                break;
            }
            // right to left.
            for(int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if(t > --b) {
                break;
            }
            // bottom to top.
            for(int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }

    public int[] spiralOrder1(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int maxRow = matrix.length,maxCol= matrix[0].length;        //最大行数,最大列数

        int resLen = maxRow * maxCol;           //结果数组长度
        int[] res = new int[resLen];
        int resIndex = 0;

        int row = 0,col=0;                        //当前行 ,当前列

        while (row <= maxRow && col <= maxCol) {
            for (int i = col; i < maxCol; i++) {        //向右
                res[resIndex++] = matrix[row][i];
                if (resIndex == resLen) {           //已满，返回
                    return res;
                }
            }
            for (int i = row + 1; i < maxRow - 1; i++) {    //向下
                res[resIndex++] = matrix[i][maxCol - 1];
                if (resIndex == resLen) {
                    return res;
                }
            }
            for (int i = maxCol - 1; i > col; i--) {        //向左
                res[resIndex++] = matrix[maxRow - 1][i];
                if (resIndex == resLen) {
                    return res;
                }
            }
            for (int i = maxRow - 1; i > row; i--) {        //向上
                res[resIndex++] = matrix[i][col];
                if (resIndex == resLen) {
                    return res;
                }
            }
            row++;                                          //转完一圈了，把起点向右下移动
            col++;
            maxRow--;                                       //最大行数，列数都减1
            maxCol--;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(matrix)));
    }
}
