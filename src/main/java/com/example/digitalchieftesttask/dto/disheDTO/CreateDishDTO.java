package com.example.digitalchieftesttask.dto.disheDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDishDTO {

    private Long restaurant;
    private String name;
    private String description;
    private float price;



}
