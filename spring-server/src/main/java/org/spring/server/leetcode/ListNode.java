package org.spring.server.leetcode;

public class ListNode {

    int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(){ }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
