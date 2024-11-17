package umc7.heehunjung.web.converter;

import umc7.heehunjung.domain.Region;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.web.dto.restaurant.RestaurantRequestDto;
import umc7.heehunjung.web.dto.restaurant.RestaurantResponseDto;

public class RestaurantConverter {

    public static RestaurantResponseDto.addDTO toAddDTO(Restaurant restaurant) {
        return RestaurantResponseDto.addDTO.builder()
                .restaurantId(restaurant.getId())
                .createAt(restaurant.getCreatedAt())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDto.addDto request, Region region) {
        return Restaurant.builder()
                .region(region)
                .name(request.getName())
                .address(request.getAddress())
                .content(request.getContent())
                .build();
    }
}
