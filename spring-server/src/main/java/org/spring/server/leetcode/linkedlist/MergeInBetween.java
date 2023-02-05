package org.spring.server.leetcode.linkedlist;

import org.spring.server.leetcode.base.ListNode;

/**
 * @author hitopei
 *
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2){
        //找到第a-1个节点  a --> pre
        ListNode preA = list1;
        for (int i = 0; i < a-1; i++) {
            preA = preA.next;
        }

        //找到第b - a + 2个节点    b --> pre
        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }
        preA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = preB;

        return list1;

    }
}
