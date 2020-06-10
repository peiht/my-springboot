package org.spring.server.leetcode.reverse;

import javafx.util.Pair;
import org.spring.server.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hitopei
 */
public class TreeMaxDepth {

    /**
     * 递归求解
     * @param treeNode
     * @return
     */
    public int maxDepth(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        } else {
            int left = maxDepth(treeNode.left);
            int right = maxDepth(treeNode.right);
            return Math.max(left, right);
        }
    }

    /**
     * 迭代解决，使用栈存储
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }
}
