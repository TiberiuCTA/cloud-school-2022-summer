package com.example.db16.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("A");
        nameList.add("B");
        nameList.add("C");
        nameList.add("D");
        nameList.add("E");
        nameList.add("F");
        nameList.add("G");
        List<User> users = new ArrayList<>();
        for(int i=0;i<5;i++) {
            Random rand = new Random();
            int upperboundname = nameList.size();
            int int_random_name = rand.nextInt(upperboundname);
            int upperboundage = 100;
            int int_random_age = rand.nextInt(upperboundage);
            users.add(new User(i,nameList.get(int_random_name),int_random_age));
        }

        users.stream()
                .filter(x->x.getAge()<18)
                .forEach(System.out::println);

        System.out.println("\n");

        users.stream()
                .map(x -> x.setAge(x.getAge()*2))
                .forEach(System.out::println);

        System.out.println("\n");

        System.out.println(users.stream()
                .max(Comparator.comparing(User::getAge)).orElse(new User()));

        System.out.println(users.stream()
                .min(Comparator.comparing(User::getAge)).orElse(new User()));

        System.out.println("\n");

        users.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n");

        users.stream()
                .filter(x -> x.getAge()<30)
                .map(y -> y.setName(y.getName().toUpperCase()))
                .sorted(Comparator.comparing(User::getAge).reversed())
                .forEach(System.out::println);

    }
}
