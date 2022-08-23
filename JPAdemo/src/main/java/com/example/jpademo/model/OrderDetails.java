package com.example.jpademo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double priceEach;

    @OneToOne
    Orders order;

    @ManyToOne
    Products product;
}
