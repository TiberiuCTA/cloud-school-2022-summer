package com.example.jpademo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String last_name;
    @NotNull
    private String first_name;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String city;
    private String postalCode;
    @NotNull
    private String country;

    @OneToMany
    List<Payments> paymentsList;

    @OneToMany
    List<Orders> ordersList;
}
