package com.example.db22.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    User user;
}
