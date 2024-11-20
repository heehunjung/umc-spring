package umc7.heehunjung.converter;

import umc7.heehunjung.domain.Region;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.dto.restaurant.RestaurantRequestDto;
import umc7.heehunjung.dto.restaurant.RestaurantResponseDto.Add;

public class RestaurantConverter {

    public static Add toAddDTO(Restaurant restaurant) {
        return Add.builder()
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
