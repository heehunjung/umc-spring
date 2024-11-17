package umc7.heehunjung.web.converter;

import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.web.dto.MemberMissionResponseDto;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Mission mission, Member member) {
        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .point(0)
                .build();
    }

    public static MemberMissionResponseDto.memberMission toMemberMissionResponseDto(MemberMission mission) {
        return MemberMissionResponseDto.memberMission.builder()
                .missionId(mission.getMission().getId())
                .memberId(mission.getMember().getId())
                .build();
    }
}
