package umc7.heehunjung.web.converter;

import java.util.List;
import org.springframework.data.domain.Page;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.web.dto.member.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.ReviewInfoDTO reviewInfoDTO(Review review) {
        return MemberResponseDTO.ReviewInfoDTO.builder()
                .name(review.getMember().getName())
                .body(review.getBody())
                .title(review.getTitle())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static MemberResponseDTO.ReviewListsDTO reviewListDTO(Page<Review> reviewList) {

        List<MemberResponseDTO.ReviewInfoDTO> reviewPreViewDTOList = reviewList.stream()
                .map(MemberConverter::reviewInfoDTO).toList();

        return MemberResponseDTO.ReviewListsDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewLists(reviewPreViewDTOList)
                .build();
    }
}
