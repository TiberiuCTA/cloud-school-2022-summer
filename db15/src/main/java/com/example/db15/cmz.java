package com.example.db15;

import com.example.db15.model.Car;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class cmz {
    public static void main(String[] args){
        //Service service=new Service();

        Optional<Car> possible=Optional.of(new Car());
        Optional<Car> possible2=Optional.empty();

        System.out.println(possible.isPresent());
        System.out.println(possible2.isPresent());
    }
}
