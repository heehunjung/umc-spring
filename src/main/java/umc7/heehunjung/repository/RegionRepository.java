package umc7.heehunjung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByName(String name);
}
