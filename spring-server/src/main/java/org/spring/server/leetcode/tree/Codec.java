package org.spring.server.leetcode.tree;

import org.spring.server.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author hitopei
 * 二叉树的序列化和反序列化
 */
public class Codec {



    public String serialize(TreeNode root) {
        StringBuffer stringBuffer = serializeHelp(root, new StringBuffer());
        stringBuffer.setLength(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public StringBuffer serializeHelp (TreeNode root, StringBuffer stringBuffer) {
        if (root == null) {
            stringBuffer.append("null,");
            return stringBuffer;
        }

        stringBuffer.append(root.val).append(",");
        stringBuffer = serializeHelp(root.left, stringBuffer);
        stringBuffer = serializeHelp(root.right, stringBuffer);
        return stringBuffer;
    }


    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(str));
        return deserialize(list);
    }

    public TreeNode deserialize(List<String> list){
        if ("null".equals(list.get(0))){
            list.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        treeNode.left = deserialize(list);
        treeNode.right = deserialize(list);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Codec().serialize(root));
        String data = "1,2,null,null,3,4,null,null,5,null,null";
        TreeNode result = new Codec().deserialize(data);
        System.out.println("1");
    }
}
