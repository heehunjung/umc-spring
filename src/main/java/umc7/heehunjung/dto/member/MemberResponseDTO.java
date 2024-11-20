package umc7.heehunjung.dto.member;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc7.heehunjung.domain.MissionStatus;

public class MemberResponseDTO{

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewListsDTO{
        List<ReviewInfoDTO> reviewLists;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewInfoDTO {
        String name;
        String title;
        String body;
        LocalDateTime createdAt;
        int score;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionList {
        List<MissionInfo> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionInfo {
        private String name;
        private String missionDescription;
        private int point;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberMissionDto {
        private Long missionId;
        private MissionStatus missionStatus;
        private LocalDateTime updateAt;
    }
}
