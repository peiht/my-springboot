package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

/**
 * @author hitopei
 *
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumBST {

    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

     public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            //相等的时候相加
            if(node.val >= L && node.val <= R) {
                ans += node.val;
            }
            //说明左子树还可能有
            if (node.val > L) {
                dfs(node.left,  L, R);
            }
            //说明右子树可能有
            if (node.val < R){
                dfs(node.right, L, R);
            }
        }
     }


    public static void main(String[] args) {

    }
}
