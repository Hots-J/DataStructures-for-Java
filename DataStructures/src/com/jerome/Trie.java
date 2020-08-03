package com.jerome;

import java.util.TreeMap;

/**
 * @program: DataStructures
 * @description: 基于映射实现的字典树
 * @author: Jerome
 * @create: 2020-08-03 23:02
 **/

public class Trie {

    private class Node {

        //判断当前字符是否为一个单词的结尾
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String words) {

        Node cur = root;
        for(int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);

            if(cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if(!cur.isWord) {
            cur.isWord = true;
            size++;
        }

    }

}
