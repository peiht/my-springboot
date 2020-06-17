package org.spring.server.leetcode.tree;

import apple.laf.JRSUIUtils;
import org.spring.server.leetcode.base.TreeNode;

/**
 * @author hitopei
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder){
        return buildHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        if (pStart > pEnd) { return null;
        }
        //根节点的值
        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - iStart;
        root.left = buildHelper(inorder, iStart, rootIndex-1, postorder, pStart, pStart + leftLength-1 );
        root.right = buildHelper(inorder, rootIndex + 1, iEnd, postorder, pStart+ leftLength, pEnd -1);
        return root;

    }
    public static void main(String[] args) {
        int[] inorder  = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = new BuildTree().buildTree(inorder, postorder);
        System.out.println();
    }
}
