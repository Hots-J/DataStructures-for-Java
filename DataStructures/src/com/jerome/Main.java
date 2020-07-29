package com.jerome;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static double testQueue(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for(int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for(int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 1; i < testData.length; i++) {
            if(arr[i-1] < arr[i])
                System.out.println("error");
        }

        System.out.println("yes");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 1000000;
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testQueue(testData, false);
        System.out.println(time1);
        double time2 = testQueue(testData, true);
        System.out.println(time2);




//        ArrayList<String> words = new ArrayList<>();
//        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
//            System.out.println("total words: " + words.size());
//
//            BSTMap<String, Integer> bstMap = new BSTMap<>();
//            for(String word : words) {
//                if(bstMap.contains(word)) {
//                    bstMap.set(word, bstMap.get(word) + 1);
//                } else {
//                    bstMap.add(word, 1);
//                }
//            }
//            System.out.println(bstMap.getSize());
//            System.out.println(bstMap.get("pride"));
//            bstMap.remove("pride");
//            System.out.println(bstMap.get("pride"));
//
//        }


//        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
//        int[] a = {37, 17, 34, 35, 37};
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            binarySearchTree.add(a[i]);
//            binarySearchTree.add(random.nextInt(5000));
//        }
//        ArrayList<Integer> arr = new ArrayList<>();
//        while (!binarySearchTree.isEmpty()){
//            arr.add(binarySearchTree.removeMax());
//        }
//        System.out.println(arr);
    }
}
