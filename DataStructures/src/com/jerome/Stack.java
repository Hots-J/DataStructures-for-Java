package com.jerome;

public interface Stack<E> {

    int getSize();
    void push(E e);
    E pop();
    E top();
    boolean isEmpty();

}
