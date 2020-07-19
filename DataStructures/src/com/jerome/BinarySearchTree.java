package com.jerome;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 二分搜索树
 * @author: Jerome
 * @create: 2020-07-19 19:33
 **/

public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {

        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 返回插入新元素e后的二叉搜索树的根，递归实现
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {

        return contains(root, e);
    }

    /**
     * 以node的为根的二叉搜索树中是否包含元素e，递归实现
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二叉搜索树，递归实现
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //访问该结点
        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二叉搜索树的前序遍历，非递归实现
     */
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二叉搜索树，递归实现
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        //访问该结点
        System.out.println(node.e);

        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二叉搜索树，递归实现
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        //访问该结点
        System.out.println(node.e);

    }
}
