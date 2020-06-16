package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hitopei
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *          1
 *        /   \
 *       2     3
 *      / \    / \
 *     4   5  6   7
 *
 *           1->null
 *         /   \
 *        2 --->3 ->null
         / \    / \
        4 ->5->6 -> 7 ->null
 *
 */
public class ConnectTree {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = queue.peek();
            for (int i = 0; i < size; i++) {
                Node node = queue.peek();
                queue.remove();
                if (i > 0) {
                    pre.next = node;
                    pre = pre.next;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Node node = new ConnectTree().connect(root);
        System.out.println("111");
    }


}
