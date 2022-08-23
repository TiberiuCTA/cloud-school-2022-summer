package com.example.db22.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Date birthDate;

    String email;

    String password;

    String country;

    String job;

    @OneToMany
    List<Post> postList;
}
