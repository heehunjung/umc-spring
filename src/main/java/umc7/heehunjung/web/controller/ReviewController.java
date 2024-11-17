package umc7.heehunjung.web.controller;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.heehunjung.apiPayload.ApiResponse;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.repository.MemberRepository;
import umc7.heehunjung.repository.ReviewRepository;
import umc7.heehunjung.service.ReviewCommandService;
import umc7.heehunjung.service.ReviewCommandServiceImpl;
import umc7.heehunjung.web.converter.ReviewConverter;
import umc7.heehunjung.web.dto.review.ReviewRequestDto;
import umc7.heehunjung.web.dto.review.ReviewResponseDto;
import umc7.heehunjung.web.dto.review.ReviewResponseDto.addReviewResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<addReviewResult> addReview(@RequestBody ReviewRequestDto.addReviewDto request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseDto(review));
    }
}
