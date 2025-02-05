package dev.hasangurbuz.keycloakrestaurants.repository;

import dev.hasangurbuz.keycloakrestaurants.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
