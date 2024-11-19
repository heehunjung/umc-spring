package umc7.heehunjung.service.memberService;

import org.springframework.data.domain.Page;
import umc7.heehunjung.domain.mapping.Review;

public interface MemberQueryService {

    Page<Review> getReviewList(Long memberId, Integer page);
}
