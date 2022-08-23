package com.example.db24.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PublicTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    TransportType transportType;

    @ManyToOne
    City city;
}
