package com.example.digitalchieftesttask.services;


import com.example.digitalchieftesttask.dto.disheDTO.CreateDishDTO;
import com.example.digitalchieftesttask.dto.disheDTO.DishDTO;
import com.example.digitalchieftesttask.entity.Dish;
import com.example.digitalchieftesttask.entity.Restaurant;
import com.example.digitalchieftesttask.mappers.DishMapper;
import com.example.digitalchieftesttask.repositories.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final RestaurantService restaurantService;
    private final DishMapper dishMapper;

    public List<DishDTO> getAllDishes() {
        return dishRepository.findAll().stream()
                .map(dishMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DishDTO> getDishDTOById(Long id) {
        return dishRepository.findById(id)
                .map(dishMapper::toDTO);
    }

    public Dish getDishById(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish not found with id: " + id));
    }

    public DishDTO createDish(CreateDishDTO createDishDTO) {
        Restaurant restaurant = restaurantService.getRestaurantById(createDishDTO.getRestaurant());


        Dish dish = dishMapper.toEntity(createDishDTO);
        dish.setRestaurant(restaurant);
        Dish savedDish = dishRepository.save(dish);
        return dishMapper.toDTO(savedDish);
    }

    public DishDTO updateDish(Long dishId, CreateDishDTO createDishDTO) {
        Dish existingDish = getDishById(dishId);
        Restaurant restaurant = restaurantService.getRestaurantById(createDishDTO.getRestaurant());
        dishMapper.updateEntity(createDishDTO,existingDish);
        existingDish.setRestaurant(restaurant);
        Dish updatedDish = dishRepository.save(existingDish);
        return dishMapper.toDTO(updatedDish);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
