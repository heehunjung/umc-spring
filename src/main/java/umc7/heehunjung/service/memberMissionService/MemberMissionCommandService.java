package umc7.heehunjung.service.memberMissionService;

import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.dto.mission.MissionRequestDto.MemberMissionDto;

public interface MemberMissionCommandService {

    MemberMission addMissionToMember(MemberMissionDto requestDto);
}
