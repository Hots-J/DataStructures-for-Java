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

        int opCount = 10000;
        LoopQueue<Integer> Lqueue = new LoopQueue<>();
        double time1 = testQueue(Lqueue, opCount);
        System.out.println(time1);

        ArrayQueue<Integer> Aqueue = new ArrayQueue<>();
        double time2 = testQueue(Aqueue, opCount);
        System.out.println(time2);
    }
}
