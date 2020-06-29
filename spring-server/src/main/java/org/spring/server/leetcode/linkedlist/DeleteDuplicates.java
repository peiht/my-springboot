package org.spring.server.leetcode.linkedlist;

import org.spring.server.leetcode.base.ListNode;

/**
 * @author hitopei
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->1
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(1);
        head.next = listNode;
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
//        ListNode listNode2 = new ListNode(3);
//        listNode1.next = listNode2;
//        ListNode listNode3 = new ListNode(3);
//        listNode2.next = listNode3;

        System.out.println(new DeleteDuplicates().deleteDuplicates(head));
    }
}
