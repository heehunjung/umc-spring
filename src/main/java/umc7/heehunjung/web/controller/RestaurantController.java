package umc7.heehunjung.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.heehunjung.apiPayload.ApiResponse;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.service.restaurantService.RestaurantCommandService;
import umc7.heehunjung.web.converter.RestaurantConverter;
import umc7.heehunjung.web.dto.restaurant.RestaurantRequestDto;
import umc7.heehunjung.web.dto.restaurant.RestaurantResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/add")
    public ApiResponse<RestaurantResponseDto.addDTO> addRestaurant(@RequestBody RestaurantRequestDto.addDto request) {
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddDTO(restaurant));
    }
}
