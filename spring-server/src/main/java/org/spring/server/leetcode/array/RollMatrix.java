package org.spring.server.leetcode.array;

/**
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 翻转
 * [
 *   [1,4,7],
 *   [2,5,8],
 *   [3,6,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 * @author hitopei
 */
public class RollMatrix {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0){
            return;
        }

        //矩阵按对角线翻转
        for (int i=0; i< length; i++){
            for (int j=i+1; j <length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //按照中轴线再次翻转
        // 位运算length >> 1
        int n = length/2;
        for (int i=0; i<length; i++){
            for (int j=0; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = temp;
            }
        }
    }

    /**
     * 单纯根据旋转的结果推断出矩阵下一个状态的坐标
     */
    public void rotate1(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][i];
                matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
                matrix[j][N - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                {4,5,6},
                {7,8,9}};

        RollMatrix rollMatrix = new RollMatrix();
        rollMatrix.rotate(matrix);
    }
}
