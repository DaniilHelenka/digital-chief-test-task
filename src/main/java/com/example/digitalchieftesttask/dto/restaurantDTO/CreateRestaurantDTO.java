package com.example.digitalchieftesttask.dto.restaurantDTO;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantDTO {
    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String name;
}
