package com.example.db24.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String medicalStatus;

    boolean dead=false;

    @ManyToOne
    City city;

    @ManyToOne
    City exCity;

    @ManyToMany
    List<Hospital> hospital;
}
