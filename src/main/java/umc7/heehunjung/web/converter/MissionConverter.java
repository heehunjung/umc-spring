package umc7.heehunjung.web.converter;

import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.web.dto.mission.MissionResponseDto;

public class MissionConverter {

    public static MissionResponseDto.MissionDto toMissionDto(Mission mission) {
        return MissionResponseDto.MissionDto.builder()
                .missionId(mission.getId())
                .build();
    }
}
