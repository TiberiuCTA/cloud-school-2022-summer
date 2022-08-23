package com.example.db24.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    City city;

    @ManyToMany
    List<Citizen> citizen;
}
