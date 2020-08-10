package org.spring.server.leetcode.tree;



import org.spring.server.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hitopei
 * 二叉树的层序遍历
 */
public class LevelOrder {

    /**
     * 使用队列辅助，迭代进行
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                cur.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(cur);
        }
        return res;
    }

    /**
     * 递归
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        dfs(root,1);
        return res;
    }
    public void dfs(TreeNode root,int level) {
        if(root == null) {
            return;
        }
        if(res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);

    }
    public static void main(String[] args) {

    }
}
