package com.example.digitalchieftesttask.controllers;

import com.example.digitalchieftesttask.dto.disheDTO.CreateDishDTO;
import com.example.digitalchieftesttask.dto.disheDTO.DishDTO;
import com.example.digitalchieftesttask.services.DishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping
    public ResponseEntity<List<DishDTO>> getAllDishes() {
        List<DishDTO> dishes = dishService.getAllDishes();
        return ResponseEntity.ok(dishes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishDTO> getDishById(@PathVariable Long id) {
        Optional<DishDTO> dishDTO = dishService.getDishDTOById(id);
        return dishDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<DishDTO> createDish(@RequestBody @Valid CreateDishDTO createDishDTO) {
        DishDTO dishDTO = dishService.createDish(createDishDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dishDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishDTO> updateDish(@PathVariable Long id,@Valid @RequestBody CreateDishDTO createDishDTO) {
        DishDTO updatedDish = dishService.updateDish(id, createDishDTO);
        return ResponseEntity.ok(updatedDish);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
