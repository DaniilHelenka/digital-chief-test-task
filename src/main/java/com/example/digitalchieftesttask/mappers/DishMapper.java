package com.example.digitalchieftesttask.mappers;

import com.example.digitalchieftesttask.dto.disheDTO.CreateDishDTO;
import com.example.digitalchieftesttask.dto.disheDTO.DishDTO;
import com.example.digitalchieftesttask.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishMapper {

    private  final ModelMapper modelMapper;

    public DishDTO toDTO(Dish dish) {
        return modelMapper.map(dish, DishDTO.class);
    }

    public Dish toEntity(CreateDishDTO createDishDTO) {
        return modelMapper.map(createDishDTO, Dish.class);
    }

    public void updateEntity(CreateDishDTO createDishDTO, Dish dish) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(createDishDTO, dish);
    }
}
