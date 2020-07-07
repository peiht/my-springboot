package org.spring.server.datastruct.matrix;

/**
 * @author hitopei
 *
 * 在二维数组中查找目标是否存在
 * 数组从左到右，从上到下都是递增的，有重复数字
 * [
 * [1,2,8,9],
 * [2,4,8,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 */
public class FindInMatrix {

    /**
     * 1.判断矩形右上角的数字是否比当前值大，如果大，则说明当前列没有目标值的可能。
     * 2.如果右上角数字比当前值小，则往下找，因为该行没有这个数字的可能。
     * @param nums
     * @param target
     * @return
     */
    public boolean findInMatrix(int[][] nums, int target){
        int n = nums.length;
        int m = nums[0].length;

        int s = 0, e = m - 1;
        while (s < n && e >= 0) {
            if (nums[s][e] == target){
                return true;
            } else if (nums[s][e] > target){
                e--;
            }else {
                s++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9}, {2,4,8,12}, {4,7,10,13}, {6,8,11,15}};
        System.out.println(new FindInMatrix().findInMatrix(matrix, 5));
    }
}
