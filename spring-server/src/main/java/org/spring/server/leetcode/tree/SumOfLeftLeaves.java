package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

/**
 * @author hitopei
 *
 *计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){
        return help(root);
    }

    public int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.left != null &&(node.left.left == null && node.left.right == null)){
            sum += node.left.val;
        }

        sum += help(node.left) + help(node.right);
        return sum;
    }

}
