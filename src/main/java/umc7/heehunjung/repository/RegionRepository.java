package umc7.heehunjung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findByName(String name);
}
