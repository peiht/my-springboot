package org.spring.server.leetcode.competition.week196;

/**
 * @author hitopei
 */
public class NumSubmat {

    public int numSubmat(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1){
                    if (i == 0 || j == 0){
                        res += mat[i][j];
                        continue;
                    }else {
                        mat[i][j] = Math.min(Math.min(mat[i][j-1], mat[i-1][j-1]), mat[i-1][j]);
                    }
                }
                res += mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
