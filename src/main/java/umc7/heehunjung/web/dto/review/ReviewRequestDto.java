package umc7.heehunjung.web.dto.review;

import lombok.Getter;

public class ReviewRequestDto {

    @Getter
    public static class addReviewDto{
        Long memberId;
        Long restaurantId;
        String title;
        String body;
    }
}
