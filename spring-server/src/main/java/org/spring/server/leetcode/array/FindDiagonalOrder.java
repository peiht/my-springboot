package org.spring.server.leetcode.array;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;

/**
 * @author hitopei
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[] res = new int[height * width];
        int i = 0, j = 0;
        int index = 0;
        int direction = 1;
        while (i < width && j < height) {
            res[index++] = matrix[i][j];
            int new_i = i + (direction == 1 ? -1 : 1);
            int new_j = j + (direction == 1 ? 1 : -1);

            if (new_i < 0 || new_i == width || new_j < 0 || new_j == height) {
                if (direction == 1) {
                    i += j == width - 1 ? 1 : 0;
                    j += j < width - 1 ? 1 : 0;
                }else {
                    i += i < height - 1 ? 1 : 0;
                    j += i == height - 1 ? 1 : 0;
                }
                direction = 1 - direction;
            }else {
                i = new_i;
                j = new_j;
            }
        }
        return res;
    }

    public int[] findDiagonalOrder1(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N*M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[] result = new FindDiagonalOrder().findDiagonalOrder1(matrix);
        System.out.println(Arrays.toString(result));

    }
}
