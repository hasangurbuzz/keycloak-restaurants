package dev.hasangurbuz.keycloakrestaurants.service;

import dev.hasangurbuz.keycloakrestaurants.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenusByRestaurantId(Long restaurantId);
    Menu createMenu(Menu menu);

}
