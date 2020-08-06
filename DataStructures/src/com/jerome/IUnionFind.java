package com.jerome;

public interface IUnionFind {

    void unionElements(int p, int q);
    boolean isConnected(int p, int q);
    int getSize();

}
