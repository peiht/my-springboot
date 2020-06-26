package org.spring.server.leetcode.linkedlist;

import org.spring.server.leetcode.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hitopei
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        Set<Integer> set = new HashSet<>();
        while (pre.next != null) {
            if (set.contains(pre.next.val)) {
                pre.next = pre.next.next;
            }else {
                set.add(pre.next.val);
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        ListNode res = new RemoveDuplicateNodes().removeDuplicateNodes(head);
        System.out.println(res.val);
    }

}
