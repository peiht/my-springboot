package org.spring.server.leetcode.linkedlist;

import org.spring.server.leetcode.base.ListNode;

/**
 * @author hitopei
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    //各种越界
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long res = toNum(l1) + toNum(l2);
        if (res == 0) {
            return new ListNode(0);
        }
        ListNode pre = new ListNode(-1);
        ListNode node = toList(res, pre, 10);
        return pre.next;
    }

    private long toNum(ListNode node) {
        ListNode node1 = new ListNode(-1);
        node1.next = node;
        long res = 0;
        long cur = 1;
        while (node1.next != null) {
            res += node1.next.val * cur;
            node1.next = node1.next.next;
            cur *= 10;
        }
        return res;
    }

    private ListNode toList(long num, ListNode pre, int cur) {
        if (num == 0) {
            return null;
        }
        int val = (int) (num%cur);
        ListNode node = new ListNode(val);
        pre.next = node;
        return toList(num/cur, node, cur);
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode res = new AddTwoNumbers().addTwoNumbers(listNode, listNode1);
        System.out.println(1);
    }
}
