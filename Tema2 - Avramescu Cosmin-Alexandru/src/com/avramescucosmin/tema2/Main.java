package com.avramescucosmin.tema2;

public class Main {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread thread1 = new Thread(intersection);
        Thread thread2 = new Thread(intersection);
        int i;
        thread1.setName("thread1");
        thread2.setName("thread2");

        for (i = 0; i < 5; i++) {
            intersection.cars1.add(new Car("N->S"));
        }
        Car.counter = 0;
        for (i = 0; i < 7; i++) {
            intersection.cars2.add(new Car("W->E"));
        }
        while (intersection.cars1.size() != 0 || intersection.cars2.size() != 0) {
            try {
                thread1.start();
                thread1.join();
                thread2.start();
                thread2.join();
                if (String.valueOf(thread1.getState()).compareTo("TERMINATED") == 0) {
                    thread1 = new Thread(intersection);
                    thread2 = new Thread(intersection);
                    thread1.setName("thread1");
                    thread2.setName("thread2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}