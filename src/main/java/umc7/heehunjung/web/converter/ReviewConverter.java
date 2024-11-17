package umc7.heehunjung.web.converter;

import java.util.Optional;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.web.dto.review.ReviewRequestDto.addReviewDto;
import umc7.heehunjung.web.dto.review.ReviewResponseDto;

public class ReviewConverter {

    public static ReviewResponseDto.addReviewResult toReviewResponseDto(Review review) {
        return ReviewResponseDto.addReviewResult.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(addReviewDto request, Restaurant restaurant, Member member) {
        return Review.builder()
                .restaurant(restaurant)
                .member(member)
                .body(request.getBody())
                .title(request.getTitle())
                .build();
    }
}
