package org.spring.server.leetcode.trie;

import java.util.HashMap;

/**
 * @author hitopei
 *
 * 实现trie树
 */
public class Trie {
    private TrieNode node;
    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = node;
        for (char c : word.toCharArray()){
            if (!curr.next.containsKey(c)) {
                TrieNode trieNode = new TrieNode();
                curr.next.put(c, trieNode);
                curr = trieNode;
            } else {
                curr = curr.next.get(c);
            }
        }
        curr.end = 1;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = node;
        for (char c : word.toCharArray()) {
            if (!curr.next.containsKey(c)) {
                return false;
            }
            curr = curr.next.get(c);
        }
        return curr.end == 1;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = node;
        for (char c : prefix.toCharArray()) {
            if (!curr.next.containsKey(c)){
                return false;
            }
            curr = curr.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");

        System.out.println(trie.startsWith("app"));
    }
}

class TrieNode{
    public int path;
    public int end;
    public HashMap<Character, TrieNode> next;

    public TrieNode(){
        path = 0;
        end = 0;
        next = new HashMap<>();
    }
}
