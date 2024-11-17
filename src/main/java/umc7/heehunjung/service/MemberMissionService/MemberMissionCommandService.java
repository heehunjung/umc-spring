package umc7.heehunjung.service.MemberMissionService;

import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.web.dto.mission.MissionRequestDto;
import umc7.heehunjung.web.dto.review.ReviewRequestDto;

public interface MemberMissionCommandService {

    MemberMission addMissionToMember(MissionRequestDto.addMissionRequestDto requestDto);
}
