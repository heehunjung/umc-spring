package umc7.heehunjung.dto.mission;

import lombok.Getter;

public class MissionRequestDto {

    @Getter
    public static class addMissionRequestDto {
        Long memberId;
        Long missionId;
    }
}
