package umc7.heehunjung.dto.mission;

import lombok.Getter;

public class MissionRequestDto {

    @Getter
    public static class MemberMissionDto {
        Long memberId;
        Long missionId;
    }

}