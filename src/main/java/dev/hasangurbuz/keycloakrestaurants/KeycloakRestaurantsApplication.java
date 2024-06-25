package dev.hasangurbuz.keycloakrestaurants;

import dev.hasangurbuz.keycloakrestaurants.model.Menu;
import dev.hasangurbuz.keycloakrestaurants.model.Restaurant;
import dev.hasangurbuz.keycloakrestaurants.service.MenuService;
import dev.hasangurbuz.keycloakrestaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class KeycloakRestaurantsApplication implements CommandLineRunner {

    private final RestaurantService restaurantService;
    private final MenuService menuService;

    public static void main(String[] args) {
        SpringApplication.run(KeycloakRestaurantsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        if (!restaurants.isEmpty()) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName("Restaurant #" + i);
            restaurant.setAddress("Address #" + i);
            restaurant = restaurantService.createRestaurant(restaurant);

            Menu menu = new Menu();
            menu.setRestaurant(restaurant);
            menu.setDailyMealName("Daily Meal #" + i);
            menuService.createMenu(menu);
        }
    }
}
