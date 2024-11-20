package umc7.heehunjung.service.restaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.heehunjung.domain.Region;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.repository.RegionRepository;
import umc7.heehunjung.repository.RestaurantRepository;
import umc7.heehunjung.converter.RestaurantConverter;
import umc7.heehunjung.dto.restaurant.RestaurantRequestDto.addDto;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;
    @Override
    public Restaurant addRestaurant(addDto request) {
        Region region = regionRepository.findByName(request.getRegion());
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request,region);
        return restaurantRepository.save(newRestaurant);
    }
}
