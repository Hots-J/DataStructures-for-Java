package com.jerome;

/**
 * @program: DataStructures
 * @description: 基于数组实现的最大堆
 * @author: Jerome
 * @create: 2020-07-29 11:52
 **/

public class MaxHeap<E extends Comparable<E>> {

    Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public MaxHeap() {
        array = new Array<>();
    }

    /**
     * 将数组直接转化为最大堆
     * @param arr
     */
    public MaxHeap(E[] arr) {
        array = new Array<>(arr);
        for(int i=parent(array.getSize()-1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 由输入的索引获取其父节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 由输入的索引获取其左孩子的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 由输入的索引获取其右孩子的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {

        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    private void siftUp(int k) {

        while (k > 0 && array.get(k).compareTo(array.get(parent(k))) > 0) {
            array.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (array.isEmpty()) {
            throw new IllegalArgumentException("The Heap is Empty!");
        }
        return array.get(0);
    }

    /**
     * 在堆中取出最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < array.getSize()) {

            // j表示左右孩子中，元素值最大的那个索引
            int j = leftChild(k);
            if (rightChild(k) < array.getSize() && array.get(rightChild(k)).compareTo(array.get(j)) > 0) {
                j = rightChild(k);
            }

            if (array.get(k).compareTo(array.get(j)) >= 0) {
                break;
            }
            array.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中最大元素，替换成新元素e
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        array.set(0, e);
        siftDown(0);
        return ret;
    }
}
