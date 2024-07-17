package com.example.digitalchieftesttask.mappers;


import com.example.digitalchieftesttask.dto.restaurantDTO.CreateRestaurantDTO;
import com.example.digitalchieftesttask.dto.restaurantDTO.RestaurantDTO;
import com.example.digitalchieftesttask.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantMapper {

    private final ModelMapper modelMapper;

    public RestaurantDTO toDTO(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    public Restaurant toEntity(CreateRestaurantDTO createRestaurantDTO) {
        return modelMapper.map(createRestaurantDTO, Restaurant.class);
    }

    public void updateEntity(CreateRestaurantDTO createRestaurantDTO, Restaurant restaurant) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(createRestaurantDTO, restaurant);
    }
}

