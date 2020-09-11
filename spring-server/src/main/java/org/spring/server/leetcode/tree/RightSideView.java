package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hitopei
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 通过次数65,690提交次数102,248
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RightSideView {
    //层序遍历，输出最右的节点
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null){
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new RightSideView().rightSideView(root));
    }
}
