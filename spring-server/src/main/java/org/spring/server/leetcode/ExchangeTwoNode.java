package org.spring.server.leetcode;

import org.spring.server.leetcode.base.ListNode;

/**
 * 两两交换节点位置
 * @author hitopei
 */
public class ExchangeTwoNode {

    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ExchangeTwoNode exchangeTwoNode = new ExchangeTwoNode();
        exchangeTwoNode.swapPairs(node1);
        System.out.println(node2.val +" "+ node2.next.val+ " "+ node2.next.next.val+" "+ node2.next.next.next.val );
    }
}
