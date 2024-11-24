package umc7.heehunjung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
