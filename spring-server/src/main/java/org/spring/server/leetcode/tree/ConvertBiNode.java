package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

/**
 * @author hitopei
 *
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBiNode {
    TreeNode treeNode;
    public TreeNode convertBiNode(TreeNode root){
        if (root == null) {
            return null;
        }
        treeNode = new TreeNode(1);
        inorder(root, treeNode);
        return treeNode.right;
    }

        TreeNode inorder(TreeNode node, TreeNode tree){
        if (node != null){
            tree = inorder(node.left, tree);
            node.left = null;
            tree.right = node;
            tree = node;
            tree = inorder(node.right, tree);
        }
        return tree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(0);
        TreeNode res = new ConvertBiNode().convertBiNode(root);
        System.out.println("complete");
    }
}
