package com.example.digitalchieftesttask.entity;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private float price;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;




}
