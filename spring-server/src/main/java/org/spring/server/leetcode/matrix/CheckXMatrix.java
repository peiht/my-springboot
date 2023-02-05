package org.spring.server.leetcode.matrix;

/**
 * @author hitopei
 *
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 * <p>
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 */
public class CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        int r = grid.length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                if (j == i || (i + j) == (r - 1)) {
                    if(grid[i][j] == 0){
                        return false;
                    }
                }
                else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},
                {0,5,0},
                {4,0,1}};
        CheckXMatrix checkXMatrix = new CheckXMatrix();
        System.out.println(checkXMatrix.checkXMatrix(grid));
    }
}
