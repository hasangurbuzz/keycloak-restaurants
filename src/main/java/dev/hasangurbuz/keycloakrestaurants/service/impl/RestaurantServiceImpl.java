package dev.hasangurbuz.keycloakrestaurants.service.impl;

import dev.hasangurbuz.keycloakrestaurants.model.Restaurant;
import dev.hasangurbuz.keycloakrestaurants.repository.RestaurantRepository;
import dev.hasangurbuz.keycloakrestaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }
}
