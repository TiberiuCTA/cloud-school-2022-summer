package com.avramescucosmin.tema2;

public class Car {
    static int counter = 0;
    int carNumber;
    char identifier;
    String direction;

    public Car(String direction) {
        synchronized (this) {
            carNumber = ++counter;
            this.direction = direction;
            if (direction.compareTo("N->S") == 0) {
                identifier = 'a';
            } else {
                identifier = 'b';
            }
        }
    }

    @Override
    public String toString() {
        return direction + ": Car " + carNumber + identifier +
                " crossing the intersection!" + " - " + Thread.currentThread().getName();
    }
}