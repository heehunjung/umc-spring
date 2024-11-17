package umc7.heehunjung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
