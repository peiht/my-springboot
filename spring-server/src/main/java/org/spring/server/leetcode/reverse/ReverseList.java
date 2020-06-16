package org.spring.server.leetcode.reverse;

import org.spring.server.leetcode.base.ListNode;

/**
 * 翻转链表
 * 迭代和递归两种方法
 *
 * @author hitopei
 */
public class ReverseList {

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = new ListNode(5);

        new ReverseList().reverseList1(head);
    }
}
