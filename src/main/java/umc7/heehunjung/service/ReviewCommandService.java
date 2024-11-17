package umc7.heehunjung.service;

import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.web.dto.review.ReviewRequestDto;

public interface ReviewCommandService {

    Review addReview(ReviewRequestDto.addReviewDto request);
}
