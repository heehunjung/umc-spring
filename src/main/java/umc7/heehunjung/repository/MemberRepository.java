package umc7.heehunjung.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);
    Optional<Member> findByUserId(String UserId);
}
