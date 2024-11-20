package umc7.heehunjung.dto.member;

import lombok.Getter;

public class MemberRequestDTO {

    @Getter
    public static class missionUpdate{
        Long missionId;
    }

    @Getter
    public static class MemberMissionDto {
        Long memberId;
        Long missionId;
    }
}
