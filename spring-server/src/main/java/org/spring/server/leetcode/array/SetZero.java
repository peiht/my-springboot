package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class SetZero {

    /**
     * 两遍。一遍确定0的位置，第二遍去修改0
     * @param matrix
     */
    public void setZero(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;
        int[] row = new int[width];
        int[] col = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1 || col[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {0,1,1}, {1,1,1}};
        new SetZero().setZero(matrix);
    }
}
