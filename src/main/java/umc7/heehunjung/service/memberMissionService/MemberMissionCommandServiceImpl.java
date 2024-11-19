package umc7.heehunjung.service.memberMissionService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.repository.MemberMissionRepository;
import umc7.heehunjung.repository.MemberRepository;
import umc7.heehunjung.repository.MissionRepository;
import umc7.heehunjung.web.converter.MemberMissionConverter;
import umc7.heehunjung.web.dto.mission.MissionRequestDto.addMissionRequestDto;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository missionMissionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission addMissionToMember(addMissionRequestDto requestDto) {
        Optional<Member> memberOptional = memberRepository.findById(requestDto.getMemberId());
        Optional<Mission> missionOptional = missionRepository.findById(requestDto.getMissionId());

        Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException("Member not found: " + requestDto.getMemberId()));
        Mission mission = missionOptional.orElseThrow(() -> new IllegalArgumentException("Mission not found: " + requestDto.getMissionId()));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(mission, member);

        return memberMissionRepository.save(memberMission);
    }
}
