package com.example.digitalchieftesttask.dto.disheDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {

    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private float price;
}
