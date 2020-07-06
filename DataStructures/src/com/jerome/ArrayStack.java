package com.jerome;

/**
 * @program: DataStructures
 * @description: 基于动态数组实现的栈
 * @author: Jerome
 * @create: 2020-07-06 16:19
 **/

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    /**
     * 默认构造函数，默认容量为10
     */
    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 获取当前栈中元素数目
     * @return 栈中元素数目
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取栈顶元素
     * @return 栈顶元素
     */
    @Override
    public E top() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(',');
        }
        res.append("] ");
        res.append("top");
        return res.toString();
    }
}
