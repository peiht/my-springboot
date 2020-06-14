package org.spring.server.leetcode.competition.week193;

/**
 * @author hitopei
 *
 *
 */
public class TreeAncestor {
    private int[] parent;
    private int n;
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;
    }

    public int getKthAncestor(int node, int k) {
        int index = node;
        while (k > 0) {
            index = parent[index];
            if (index == -1) {
                return index;
            }
            k--;
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] parent = {-1, 0, 0, 0, 3};
        TreeAncestor treeAncestor = new TreeAncestor(n, parent);
        System.out.println(treeAncestor.getKthAncestor(1,5));
    }
}
