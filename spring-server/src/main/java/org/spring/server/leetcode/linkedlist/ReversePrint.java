package org.spring.server.leetcode.linkedlist;

import org.spring.server.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode pre = head;
        while (pre != null){
            res.add(pre.val);
            pre = pre.next;
        }

        int n = res.size();
        int[] ans = new int[n];
        int index = 0;
        for (int i = n-1; i >= 0; i--) {
            ans[index] = res.get(i);
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = null;
        int[] res = new ReversePrint().reversePrint(head);
        System.out.println(Arrays.toString(res));
    }
}
