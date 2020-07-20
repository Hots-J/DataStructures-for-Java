package com.jerome;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
//        int[] a = {37, 17, 34, 35, 37};
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
//            binarySearchTree.add(a[i]);
            binarySearchTree.add(random.nextInt(5000));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (!binarySearchTree.isEmpty()){
            arr.add(binarySearchTree.removeMax());
        }
        System.out.println(arr);
    }
}
