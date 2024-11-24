package umc7.heehunjung.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.repository.MemberRepository;
import umc7.heehunjung.repository.RestaurantRepository;
import umc7.heehunjung.repository.ReviewRepository;
import umc7.heehunjung.converter.ReviewConverter;
import umc7.heehunjung.dto.review.ReviewRequestDto.addReviewDto;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Review addReview(addReviewDto request) {
        //옵셔널 처리는 안하겠음..
        Optional<Member> memberOptional = memberRepository.findById(request.getMemberId());
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(request.getRestaurantId());

        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException("Member not found: " + request.getMemberId()));
        Restaurant restaurant = restaurantOptional.orElseThrow(() -> new IllegalArgumentException("Restaurant not found: " + request.getRestaurantId()));

        Review review = ReviewConverter.toReview(request, restaurant, member);

        return reviewRepository.save(review);
    }
}
