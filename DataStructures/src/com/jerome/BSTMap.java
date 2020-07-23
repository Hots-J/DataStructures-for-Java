package com.jerome;

/**
 * @program: DataStructures
 * @description: 基于二分搜索树实现的映射
 * @author: Jerome
 * @create: 2020-07-23 13:26
 **/

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    private Node getNode(Node node, K key) {
        if(node == null) {
            return null;
        }

        if(node.key.compareTo(key) < 0) {
            return getNode(node.left, key);
        }
        else if(node.key.compareTo(key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(root, key);
        if(node == null) {
            root = add(root, key, value);
        } else {
            node.value = value;
        }

    }

    private Node add(Node node, K key, V value) {
        if(node == null) {
            size++;
            node = new Node(key, value);
            return node;
        }

        if(node.key.compareTo(key) < 0) {
            node.left = add(node.left, key, value);
        } else if(node.key.compareTo(key) > 0) {
            node.right = add(node.right, key, value);
        }
        return node;

    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if(node == null) {
            return null;
        }

        if(node.key.compareTo(key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if(node.key.compareTo(key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {

            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }

    private Node minimum(Node node) {
        if(node == null) {
            return null;
        }
        if(node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }

    private Node removeMin(Node node) {

        if(node == null) {
            return null;
        }

        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        } else {
            node.left = removeMin(node.left);
            return node;
        }

    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node == null) {
            throw new IllegalArgumentException(key + "doesn't exist !");
        }
        node.value = value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
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
