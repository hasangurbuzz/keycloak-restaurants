package dev.hasangurbuz.keycloakrestaurants.controller;

import dev.hasangurbuz.keycloakrestaurants.dto.CreateMenuRequest;
import dev.hasangurbuz.keycloakrestaurants.dto.CreateRestaurantRequest;
import dev.hasangurbuz.keycloakrestaurants.model.Menu;
import dev.hasangurbuz.keycloakrestaurants.model.Restaurant;
import dev.hasangurbuz.keycloakrestaurants.service.MenuService;
import dev.hasangurbuz.keycloakrestaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuService menuService;

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody CreateRestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getRestaurantName());
        restaurant.setAddress(request.getRestaurantAddress());
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("/{id}/menus")
    public List<Menu> getMenus(@PathVariable String id) {
        return menuService.getMenusByRestaurantId(Long.valueOf(id));
    }

    @PostMapping("/{id}/menus")
    public Menu createMenu(@PathVariable String id, @RequestBody CreateMenuRequest request) {
        Restaurant restaurant = restaurantService.getById(Long.valueOf(id));

        Menu menu = new Menu();
        menu.setDailyMealName(request.getDailyMealName());
        menu.setRestaurant(restaurant);
        return menuService.createMenu(menu);
    }

}
