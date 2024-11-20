package umc7.heehunjung.service.memberMissionService;

import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.dto.mission.MissionRequestDto;

public interface MemberMissionCommandService {

    MemberMission addMissionToMember(MissionRequestDto.addMissionRequestDto requestDto);
}
