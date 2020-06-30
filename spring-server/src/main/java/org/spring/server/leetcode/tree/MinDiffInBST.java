package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hitopei
 *
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *  
 *
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDiffInBST {

    /**
     * 题是任意两节点，我做的是相邻两节点
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        return  help(root, res);
    }

    public int help(TreeNode node, int res) {
        if (node == null || (node.right == null && node.left == null)) {
            return res;
        }
        if (node.left != null && node.right == null) {
            res = Math.min(res, Math.abs(node.val - node.left.val));
        }
        if (node.right != null && node.left == null) {
            res = Math.min(res, Math.abs(node.val - node.right.val));
        }
         if (node.left != null && node.right != null){
            int left = Math.min(res, Math.abs(node.val - node.left.val));
            int right = Math.min(res, Math.abs(node.val - node.right.val));
            res = Math.min(left, right);
        }
        return Math.min(help(node.left, res), help(node.right, res));
    }


    /**
     * 任意两个节点的差值，遍历一下，排序，查找差值最小
     * @param root
     * @return
     */
    public int minDiffInBST1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        List<Integer> list1 = list.stream().sorted().collect(Collectors.toList());
        int len = list1.size();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len-1; i++) {
            int sum = Math.abs(list1.get(i) - list1.get(i+1));
            res = Math.min(sum, res);
        }
       return res;
    }

    public void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);

        System.out.println(new MinDiffInBST().minDiffInBST1(root));
    }
}
