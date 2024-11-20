package umc7.heehunjung.service;

import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.dto.review.ReviewRequestDto;

public interface ReviewCommandService {

    Review addReview(ReviewRequestDto.addReviewDto request);
}
