package com.jerome;

/**
 * @program: DataStructures
 * @description: 基于链表实现的映射
 * @author: Jerome
 * @create: 2020-07-23 09:42
 **/

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node() {
            key = null;
            value = null;
            next = null;
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 通过key返回节点
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 映射中添加元素
     * 如果当前key已存在，则将对应的值赋值为新的值
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        else
            node.value = value;
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.key.equals(key)) {
                Node delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 将key键对应的值设置成新的值
     * @param key
     * @param value
     */
    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException(key + "doesn't exist !");
        }
        node.value = value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
