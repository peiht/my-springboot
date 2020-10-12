package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hitopei
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        help(root, "", res);
        return res;
    }

    public void help(TreeNode node, String path, List<String> res){
        if (node != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(node.val);
            if (node.left == null && node.right == null){
                res.add(sb.toString());
            } else {
                sb.append("->");
                help(node.left, sb.toString(), res);
                help(node.right, sb.toString(), res);
            }
        }
    }
}