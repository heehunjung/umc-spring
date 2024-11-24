package umc7.heehunjung.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.heehunjung.apiPayload.ApiResponse;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.service.restaurantService.RestaurantCommandService;
import umc7.heehunjung.service.restaurantService.RestaurantQueryService;
import umc7.heehunjung.converter.RestaurantConverter;
import umc7.heehunjung.dto.restaurant.RestaurantRequestDto;
import umc7.heehunjung.dto.restaurant.RestaurantResponseDto;
import umc7.heehunjung.dto.restaurant.RestaurantResponseDto.Add;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/add")
    public ApiResponse<Add> addRestaurant(@RequestBody RestaurantRequestDto.addDto request) {
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddDTO(restaurant));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 레스토랑의 미션 목록 조회 API",description = "특정 레스토랑의 미션들의 목록을 조회하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<RestaurantResponseDto.MissionList> getMissions(@PathVariable Long restaurantId) {
        RestaurantResponseDto.MissionList result  = restaurantQueryService.getMission(restaurantId);
        return ApiResponse.onSuccess(result);
    }
}
