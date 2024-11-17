package umc7.heehunjung.web.dto.mission;

import lombok.Getter;

public class MissionRequestDto {

    @Getter
    public static class addMissionRequestDto {
        Long memberId;
        Long missionId;
    }
}
