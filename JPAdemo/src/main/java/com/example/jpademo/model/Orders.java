package com.example.jpademo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private Date order_date;
    private Date shipped_date;
    @NotNull
    private String status;
    private String comments;

    @ManyToOne
    Customer customer;

    @OneToOne
    OrderDetails orderDetails;
}
