package com.example.jpademo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue
    private String code;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Integer stock;
    @NotNull
    private Double price;

    @OneToMany
    List<Products> productsList;
}
