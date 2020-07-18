package com.jerome;

import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime  = System.nanoTime();

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

        LinkedListQueue<Integer> linkedList = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            linkedList.enqueue(i);
            System.out.println(linkedList);
            if(i % 3 == 0) {
                linkedList.dequeue();
                System.out.println(linkedList);
            }
        }

    }
}
