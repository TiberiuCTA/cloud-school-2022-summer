package com.avramescucosmin.tema2;

import java.util.*;
import java.util.concurrent.Semaphore;

public class Intersection implements Runnable {
    static final int MAX_CARS_CROSSING = 3;
    static final Semaphore semaphore1 = new Semaphore(1);
    static final Semaphore semaphore2 = new Semaphore(0);
    LinkedList<Car> cars1 = new LinkedList<>();
    LinkedList<Car> cars2 = new LinkedList<>();

    @Override
    public void run() {
        try {
            if (semaphore1.availablePermits() == 1) {
                System.out.println("---Semaphore 1 = GREEN <> Semaphore 2 = RED !");
                semaphore1.acquire();
                cross(cars1);
                semaphore2.release();
            } else if (semaphore2.availablePermits() == 1) {
                System.out.println("---Semaphore 1 = RED <> Semaphore 2 = GREEN !");
                semaphore2.acquire();
                cross(cars2);
                semaphore1.release();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void cross(LinkedList<Car> cars) throws InterruptedException {
        int i;
        if (cars.size() == 0) {
            System.out.println("There are no other cars waiting at this semaphore!");
        } else {
            for (i = 0; i < MAX_CARS_CROSSING && cars.size() != 0; i++) {
                System.out.println(cars.get(0));
                cars.remove(0);
                Thread.sleep(1000);
            }
        }
    }
}