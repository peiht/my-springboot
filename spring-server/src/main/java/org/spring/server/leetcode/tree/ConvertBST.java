package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

/**
 * @author hitopei
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBST {

    int share = 0;
    public TreeNode covertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        middle(root);
        return root;
    }

    public void middle(TreeNode node){
        if (node == null) {
            return;
        }

        middle(node.right);
        node.val += share;
        share = node.val;
        middle(node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        ConvertBST convertBST = new ConvertBST();
        TreeNode res = convertBST.covertBST(root);
        System.out.println(res);
    }
}
