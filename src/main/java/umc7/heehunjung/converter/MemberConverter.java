package umc7.heehunjung.converter;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.dto.member.MemberRequestDTO;
import umc7.heehunjung.dto.member.MemberResponseDTO;
import umc7.heehunjung.dto.member.MemberResponseDTO.MissionList;

public class MemberConverter {

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .gender(request.getGender())
                .userId(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }
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

    public static MemberResponseDTO.MissionInfo missionInfoDTO(MemberMission mission) {

        return MemberResponseDTO.MissionInfo
                .builder()
                .missionDescription(mission.getMission().getMissionDescription())
                .point(mission.getPoint())
                .name(mission.getMission().getRestaurant().getName())
                .build();
    }

    public static MemberResponseDTO.MissionList MissionListDTO(Page<MemberMission> list) {

        List<MemberResponseDTO.MissionInfo> missionInfoList = list.stream()
                .map(MemberConverter::missionInfoDTO)
                .toList();

        return MemberResponseDTO.MissionList.builder()
                .missionList(missionInfoList)
                .isLast(list.isLast())
                .isFirst(list.isFirst())
                .totalPage(list.getTotalPages())
                .totalElements(list.getTotalElements())
                .listSize(missionInfoList.size())
                .build();
    }
}
