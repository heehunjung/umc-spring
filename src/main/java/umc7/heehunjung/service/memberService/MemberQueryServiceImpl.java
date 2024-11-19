package umc7.heehunjung.service.memberService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.repository.MemberRepository;
import umc7.heehunjung.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    public static final int PAGE_SIZE = 10;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + memberId));
        page -= 1;
        return reviewRepository.findAllByMember(member, PageRequest.of(page, PAGE_SIZE));
    }
}
