package dev.hasangurbuz.keycloakrestaurants.repository;

import dev.hasangurbuz.keycloakrestaurants.model.Menu;
import dev.hasangurbuz.keycloakrestaurants.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurantId(Long restaurantId);
}
