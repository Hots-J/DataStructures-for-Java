package com.jerome;

/**
 * @program: Array
 * @description: 动态数组
 * @author: Jerome
 * @create: 2020-07-04 22:16
 **/

public class Array<E> {
     /** 存储数据 **/
    private E[] data;
    /** 当前存储元素数目 **/
    private int size;

    /**
     * 含参构造函数，传入数组容量
     * @param capacity：数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造函数，默认数组容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取当前数组元素数目
     * @return 数组中元素数目
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组最大容量
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末尾添加元素
     * @param e: 添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头添加元素
     * @param e: 添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向数组的index索引处添加元素
     * @param index: 要添加元素的索引位置
     * @param e: 添加的元素
     */
    public void add(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add fail2，Illegal index");
        }

        if(size == data.length) {
            resize(2 * data.length);
        }

        for(int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取索引处的值
     * @param index: 获取值的索引
     * @return 索引处的值
     */
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail1，Illegal index");
        }
        return data[index];
    }

    /**
     * 获取尾部的值
     * @return 末尾的值
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取头部的值
     * @return 头部的值
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 设置索引处的值
     * @param index: 设置值的索引
     * @param e: 设为的值
     */
    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("set fail1，Illegal index");
        }
        data[index] = e;
    }

    /**
     * 查找某个元素
     * @param e 查找的元素的值
     * @return 元素所在的索引，未找到返回-1
     */
    public int find(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除索引处的值
     * @param index: 删除值的索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail1，Illegal index");
        }

        E ret = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0) {   //防止复杂度震荡
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 删除数组首元素
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组尾元素
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定的元素
     * @param e 删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    /**
     * 数组的重调大小
     * @param newCapacity: 新的数组容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array.size = %d, Array.capacity = %d \n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}
