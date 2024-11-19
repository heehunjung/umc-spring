package umc7.heehunjung.service.restaurantService;

import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.web.dto.restaurant.RestaurantRequestDto;

public interface RestaurantCommandService {
    Restaurant addRestaurant(RestaurantRequestDto.addDto request);
}
