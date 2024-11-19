package umc7.heehunjung.service.restaurantService;

import umc7.heehunjung.web.dto.restaurant.RestaurantResponseDto;

public interface RestaurantQueryService {
    RestaurantResponseDto.MissionList getMission(Long restaurantId);
}
