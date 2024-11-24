package umc7.heehunjung.service.memberService;

import org.springframework.data.domain.Page;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.dto.member.MemberResponseDTO;

public interface MemberQueryService {

    Page<Review> getReviewList(Long memberId, Integer page);
    MemberResponseDTO.MissionList getMissionList(Long memberId, Integer page);
}
