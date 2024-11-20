package umc7.heehunjung.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.Restaurant;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findAllByRestaurant(Restaurant restaurant);
}
