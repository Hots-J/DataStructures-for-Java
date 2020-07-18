package com.jerome;

/**
 * @program: DataStructures
 * @description: 链表实现的栈
 * @author: Jerome
 * @create: 2020-07-18 10:01
 **/

public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);

    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E top() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: Top ");
        res.append(linkedList);
        return res.toString();
    }
}
