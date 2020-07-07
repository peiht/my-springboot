package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hitopei
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum {


    /**
     * 递归方式
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * 广度优先遍历
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum){
        if (root == null) {
            return false;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> valSum = new LinkedList<>();
        treeNodeQueue.offer(root);
        valSum.offer(root.val);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            int val = valSum.poll().intValue();
            if (node.left == null && node.right == null) {
                if (val == sum){
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                treeNodeQueue.offer(node.left);
                valSum.offer(node.left.val + val);
            }

            if (node.right != null) {
                treeNodeQueue.offer(node.right);
                valSum.offer(node.right.val + val);
            }

        }
        return false;
    }


    public static void main(String[] args) {

    }
}
