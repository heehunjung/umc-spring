package umc7.heehunjung.service.RestaurantService;

import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.web.dto.restaurant.RestaurantRequestDto;

public interface RestaurantCommandService {
    Restaurant addRestaurant(RestaurantRequestDto.addDto request);
}
