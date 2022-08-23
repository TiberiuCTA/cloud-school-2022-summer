package com.example.db24.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    List<Hospital> hospitalList=new ArrayList<>();

    @OneToMany
    List<Citizen> citizens=new ArrayList<>();
}
