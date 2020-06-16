package org.spring.server.leetcode;

import org.spring.server.leetcode.base.TreeNode;

/**
 * @author hitopei
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dsf(root.left, root.right);
    }

    boolean dsf(TreeNode left, TreeNode right){
        //同时为null，条件成立
        if (left == null && right == null) {
            return true;
        }

        //只有一方为空，不成立
        if (left == null || right == null){
            return false;
        }

        //左右值不相等，不成立
        if (left.val != right.val) {
            return false;
        }

        return dsf(left.left, right.right) && dsf(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);

        TreeNode left11 = new TreeNode(3);
        TreeNode left12 = new TreeNode(4);

        TreeNode right11 = new TreeNode(4);
        TreeNode right12 = new TreeNode(3);
        root.left = left1;
        root.right = right1;

        left1.left = left11;
        left1.right = left12;

        right1.left = right11;
        right1.right = right12;

        System.out.println(new SymmetricBinaryTree().isSymmetric(root));
    }
}
