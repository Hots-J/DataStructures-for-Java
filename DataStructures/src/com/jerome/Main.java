package com.jerome;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static double testUnion(UnionFind testUn, int m) {

        int size = testUn.getSize();
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            testUn.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            testUn.isConnected(a, b);
        }


        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int m = 1000000;
        int size = 1000000;

        UnionFind unionFind = new UnionFind(size);
        double time = testUnion(unionFind, m);
        System.out.println(time);


//        Integer[] nums = {-2, 0, 3, -5, 2, 1};
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Math::max);
//
//        System.out.println(segmentTree);
//        System.out.println(segmentTree.query(0, 5));
//        int n = 1000000;
//        Integer[] testData = new Integer[n];
//        Random random = new Random();
//        for(int i = 0; i < n; i++) {
//            testData[i] = random.nextInt(Integer.MAX_VALUE);
//        }
//        double time1 = testQueue(testData, false);
//        System.out.println(time1);
//        double time2 = testQueue(testData, true);
//        System.out.println(time2);




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
