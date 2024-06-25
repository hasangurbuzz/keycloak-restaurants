package dev.hasangurbuz.keycloakrestaurants.service;

import dev.hasangurbuz.keycloakrestaurants.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getRestaurants();
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant getById(Long id);
}
