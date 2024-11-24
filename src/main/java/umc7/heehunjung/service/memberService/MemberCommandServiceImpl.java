package umc7.heehunjung.service.memberService;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc7.heehunjung.converter.MemberConverter;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.MissionStatus;
import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.dto.member.MemberRequestDTO;
import umc7.heehunjung.dto.member.MemberResponseDTO.MemberMissionDto;
import umc7.heehunjung.repository.MemberMissionRepository;
import umc7.heehunjung.repository.MemberRepository;
import umc7.heehunjung.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository missionMissionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void joinMember(MemberRequestDTO.JoinDto request){
        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        memberRepository.save(newMember);
    }

    @Override
    public MemberMissionDto updateMission(MemberRequestDTO.MemberMissionDto missionDto) {
        Member member = memberRepository.findById(missionDto.getMemberId()).orElse(null);
        Mission mission = missionRepository.findById(missionDto.getMissionId()).orElse(null);

        MemberMission missionMission = missionMissionRepository.findById(missionDto.getMissionId()).orElse(null);

        missionMission.updateStatus(MissionStatus.COMPLETED);

        // 변경사항 저장
        missionMissionRepository.save(missionMission);
        // null 값 처리 안함..

        return MemberMissionDto.builder()
                .missionId(missionDto.getMissionId())
                .missionStatus(missionMission.getStatus())
                .updateAt(missionMission.getUpdatedAt() )
                .build();
    }
}
