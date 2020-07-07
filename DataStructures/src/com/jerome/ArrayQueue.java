package com.jerome;

/**
 * @program: DataStructures
 * @description: 数组队列
 * @author: Jerome
 * @create: 2020-07-07 10:33
 **/

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 默认构造函数，默认容量为10
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 获取当前队列中元素数目
     * @return 队列中元素数目
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 获取队列头元素
     * @return 队列头元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        res.append('[');
        for(int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(',');
        }
        res.append("] tail");
        return res.toString();
    }
}
