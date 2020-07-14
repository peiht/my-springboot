package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hitopei
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class FindDuplicateSubtrees {

    Map<String, Integer> map;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        serializeTree(root);
        return ans;

    }

    /**
     * 序列化树
     * @param node
     * @return
     */
    public String serializeTree(TreeNode node){
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + serializeTree(node.left) + "," + serializeTree(node.right);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        //有相同的就添加node
        if (map.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
    }

}
