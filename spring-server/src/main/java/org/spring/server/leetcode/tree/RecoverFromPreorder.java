package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hitopei
 *
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecoverFromPreorder {
    public TreeNode recoverFromPreorder(String S) {
        Deque<Node> stack = new ArrayDeque<>();
        int depth = 0;
        int iStart = 0;
        for (int i=1; i < S.length(); i++) {
            char c = S.charAt(i);
            char p = S.charAt(i-1);
            if (c == '-' && p != '-') {
                int val = Integer.parseInt(S.substring(iStart, i));
                while (!stack.isEmpty() && stack.peekLast().depth >= depth) {
                    Node child = stack.removeLast();
                    assert stack.peekLast() != null;
                    buildTree(stack.peekLast(), child);
                }
                stack.addLast(new Node(new TreeNode(val), depth));
                depth = 1;
                iStart = i + 1;
            }
            if (c == '-' && p == '-') {
                depth++;
                iStart = i + 1;
            }
        }

        int val = Integer.parseInt(S.substring(iStart, S.length()));
        while (!stack.isEmpty() && stack.peekLast().depth >= depth) {
            Node child = stack.removeLast();
            buildTree(stack.peekLast(), child);
        }
        stack.addLast(new Node(new TreeNode(val), depth));
        while (stack.size() > 1) {
            Node child = stack.removeLast();
            buildTree(stack.peekLast(), child);
        }
        return stack.peekLast().treeNode;
    }

    public void buildTree(Node parent, Node child) {
        if (parent.treeNode.left == null) {
            parent.treeNode.left = child.treeNode;
        } else {
            parent.treeNode.right = child.treeNode;
        }
    }

    private class Node{
        public int depth;
        public TreeNode treeNode;
        public Node(TreeNode treeNode, int depth){
            this.depth = depth;
            this.treeNode = treeNode;
        }
    }

    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        TreeNode root = new RecoverFromPreorder().recoverFromPreorder(s);
        System.out.println();
    }
}
