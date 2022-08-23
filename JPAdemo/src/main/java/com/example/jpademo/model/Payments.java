package com.example.jpademo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Data
public class Payments {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private Date payment_date;
    @NotNull
    private Double amount;

    @ManyToOne
    Customer customer;
}
