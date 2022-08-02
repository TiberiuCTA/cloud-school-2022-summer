package com.example.myfirst.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String status;
    private String comments;
}
