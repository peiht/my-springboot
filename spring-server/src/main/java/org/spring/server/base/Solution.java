package org.spring.server.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.spring.server.base.TreeNode;
import sun.reflect.generics.tree.Tree;


/**
 * @author Administrator
 */
public class Solution {

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode node, List<Integer> list){
        if (node != null){
            list.add(node.value);
            preorder(node.left,list);
            preorder(node.right,list);

        }
    }

    //中序遍历
    public List<Integer> midorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        midorder(root, result);
        return result;
    }

    public void midorder(TreeNode node, List<Integer> list){
        if (node != null){
            midorder(node.left,list);
            list.add(node.value);
            midorder(node.right,list);

        }
    }

    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode node = queue.peek();
            queue.poll();
            list.add(node.value);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        root.right = right1;
        root.right.left = right2;
        List<List<Integer>> result = solution.levelOrder(root);
        result.forEach(e -> System.out.println(e));
    }
}
