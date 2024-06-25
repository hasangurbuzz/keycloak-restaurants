package dev.hasangurbuz.keycloakrestaurants.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRestaurantRequest {
    private String restaurantName;
    private String restaurantAddress;
}
