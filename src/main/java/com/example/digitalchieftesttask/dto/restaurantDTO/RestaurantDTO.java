package com.example.digitalchieftesttask.dto.restaurantDTO;


import com.example.digitalchieftesttask.dto.disheDTO.DishDTO;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    private long id;

    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String name;

    private String address;
    private String phone_number;
    private List<DishDTO> dishes;

}
