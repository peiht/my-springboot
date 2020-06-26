package org.spring.server.leetcode.linkedlist;

public class MyLinkedList {


    int size;
    Node head;

    /**
     * @author hitopei
     * node定义
     */
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public MyLinkedList(){
        this.head = new Node(0);
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw  new IllegalArgumentException("index invalid :" + index);
        }
        Node node = head;
        while (index-- >= 0) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size-1, val);
    }

    public void addAtIndex(int index, int val){
        if (index < 0 || index >= size) {
            throw  new IllegalArgumentException("index invalid :" + index);
        }
        Node node = head;
        while (index-- > 0 ){
            node = node.next;
        }

        Node newNode = new Node(val);
        newNode.next = node.next;
        node.next = newNode;

        size++;
    }

    public void deleteAtIndex (int index) {
        if (index < 0 || index >= size) {
            throw  new IllegalArgumentException("index invalid :" + index);
        }
        Node node = head;
        while (--index >= 0 ){
            node = node.next;
        }
        node.next = node.next.next;
        size--;
    }


}
