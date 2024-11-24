package umc7.heehunjung.service.restaurantService;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.repository.MissionRepository;
import umc7.heehunjung.repository.RestaurantRepository;
import umc7.heehunjung.dto.restaurant.RestaurantResponseDto;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public RestaurantResponseDto.MissionList getMission(Long restaurantId) {
        // Restaurant 객체 조회
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid restaurant ID"));

        // Mission 리스트 생성
        List<RestaurantResponseDto.Mission> missions = missionRepository.findAllByRestaurant(restaurant).stream()
                .map(mission -> RestaurantResponseDto.Mission.builder()
                        .description(mission.getMissionDescription())
                        .point(mission.getPoint())
                        .missionName(mission.getName())
                        .restaurantName(mission.getRestaurant().getName())
                        .build()
                )
                .collect(Collectors.toList());

        // MissionList 반환
        return RestaurantResponseDto.MissionList.builder()
                .Missions(missions)
                .build();
    }
}
