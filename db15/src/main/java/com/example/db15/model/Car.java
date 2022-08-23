package com.example.db15.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    String color;
    Integer hp;
}
