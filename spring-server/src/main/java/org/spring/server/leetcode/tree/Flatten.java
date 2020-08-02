package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hitopei
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Flatten {

    public void flatten(TreeNode root) {

        List<TreeNode> res = new ArrayList<>();
        dfs(root, res);
        int size = res.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = res.get(i - 1), cur = res.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.left != null) {
            dfs(node.left, list);
        }
        if (node.right != null){
            dfs(node.right, list);
        }
    }

    /**
     * 借助栈实现
     * @param root
     */
    public void flatten1(TreeNode root){
        
    }
}
