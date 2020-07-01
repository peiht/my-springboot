package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLength {

    /**
     * 滑动窗口
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n-i);
            int maxLen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxLen);
        }

        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m-i);
            int maxLen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxLen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            }else {
                k =0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    /**
     * 动态规划
     * @param A
     * @param B
     * @return
     */
    public int findLength1(int[] A, int[] B) {
        int n =  A.length, m = B.length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;

        for (int i=n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i+1][j+1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A= {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(new FindLength().findLength1(A, B));
    }
}
