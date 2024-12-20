package umc7.heehunjung.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
