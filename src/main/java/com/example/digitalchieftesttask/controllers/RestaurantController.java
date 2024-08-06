package com.example.digitalchieftesttask.controllers;


import com.example.digitalchieftesttask.dto.restaurantDTO.CreateRestaurantDTO;
import com.example.digitalchieftesttask.dto.restaurantDTO.RestaurantDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.digitalchieftesttask.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id) {
        Optional<RestaurantDTO> restaurantDTO = restaurantService.getRestaurantDTOById(id);
        return restaurantDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody @Valid CreateRestaurantDTO createRestaurantDTO) {
        RestaurantDTO restaurantDTO = restaurantService.createRestaurant(createRestaurantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable Long id, @RequestBody @Valid CreateRestaurantDTO createRestaurantDTO) {
        RestaurantDTO updatedRestaurant = restaurantService.updateRestaurant(id, createRestaurantDTO);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
