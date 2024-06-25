package dev.hasangurbuz.keycloakrestaurants.service.impl;

import dev.hasangurbuz.keycloakrestaurants.model.Menu;
import dev.hasangurbuz.keycloakrestaurants.repository.MenuRepository;
import dev.hasangurbuz.keycloakrestaurants.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public List<Menu> getMenusByRestaurantId(Long restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }
}
