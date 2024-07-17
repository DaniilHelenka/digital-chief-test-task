package com.example.digitalchieftesttask.services;

import com.example.digitalchieftesttask.dto.restaurantDTO.CreateRestaurantDTO;
import com.example.digitalchieftesttask.dto.restaurantDTO.RestaurantDTO;
import com.example.digitalchieftesttask.entity.Restaurant;
import com.example.digitalchieftesttask.exeptions.SameNameException;
import com.example.digitalchieftesttask.mappers.RestaurantMapper;
import com.example.digitalchieftesttask.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {


    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(restaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RestaurantDTO> getRestaurantDTOById(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurantMapper::toDTO);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found with id: " + id));
    }

    public RestaurantDTO createRestaurant(CreateRestaurantDTO createRestaurantDTO) {
        try {
            Restaurant restaurant = restaurantMapper.toEntity(createRestaurantDTO);
            Restaurant savedRestaurant = restaurantRepository.save(restaurant);
            return restaurantMapper.toDTO(savedRestaurant);
        } catch (DataIntegrityViolationException ex) {
            throw new SameNameException(HttpStatus.CONFLICT, "Restaurant with the same  name  already exists.", ex);
        }
    }
    public RestaurantDTO updateRestaurant (Long id, CreateRestaurantDTO createRestaurantDTO) {
        Restaurant existingRestaurant = getRestaurantById(id);
        restaurantMapper.updateEntity(createRestaurantDTO,existingRestaurant);
        try{
            Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
            return restaurantMapper.toDTO(updatedRestaurant);
        } catch (DataIntegrityViolationException ex) {
            throw new SameNameException(HttpStatus.CONFLICT, "Restaurant with the same first name and last name already exists.", ex);
        }
    }
    public void deleteAuthor(Long id) {
       restaurantRepository.deleteById(id);
    }
}