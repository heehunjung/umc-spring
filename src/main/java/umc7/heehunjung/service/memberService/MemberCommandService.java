package umc7.heehunjung.service.memberService;

import umc7.heehunjung.dto.member.MemberRequestDTO;
import umc7.heehunjung.dto.member.MemberResponseDTO;

public interface MemberCommandService {
        MemberResponseDTO.MemberMissionDto updateMission(MemberRequestDTO.MemberMissionDto missionDto);
}
