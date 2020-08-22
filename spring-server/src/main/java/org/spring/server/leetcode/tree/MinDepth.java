package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }

    /**
     * bfs
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root){
       if (root == null){
           return 0;
       }

       Queue<QueueNode> queue = new LinkedList<>();
       queue.offer(new QueueNode(root, 1));
       while (!queue.isEmpty()) {
           QueueNode queueNode = queue.poll();
           TreeNode node = queueNode.node;
           int depth = queueNode.depth;
           if (node.left == null && node.right == null){
               return depth;
           }
           if (node.left != null) {
               queue.offer(new QueueNode(node.left, depth + 1));
           }
           if (node.right != null) {
               queue.offer(new QueueNode(node.right, depth + 1));
           }
       }
       return 0;
    }

    class QueueNode{
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
