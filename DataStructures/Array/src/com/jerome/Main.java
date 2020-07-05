package com.jerome;

public class Main {

    public static void main(String[] args) {

       Array<String> arr = new Array<>(20);

        for (int i = 0; i < 10; i++) {
            arr.addLast("abc");
        }

        System.out.println(arr);

        arr.remove(7);
        System.out.println(arr);
    }
}
