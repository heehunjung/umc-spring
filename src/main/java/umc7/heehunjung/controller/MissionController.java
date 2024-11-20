package umc7.heehunjung.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.heehunjung.apiPayload.ApiResponse;
import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.dto.memberMission.MemberMissionResponseDto;
import umc7.heehunjung.dto.mission.MissionRequestDto.MemberMissionDto;
import umc7.heehunjung.repository.MissionRepository;
import umc7.heehunjung.service.memberMissionService.MemberMissionCommandService;
import umc7.heehunjung.converter.MemberMissionConverter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    public final MissionRepository missionRepository;
    public final MemberMissionCommandService memberMissionCommandService;
    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDto.memberMission> addMission(@RequestBody MemberMissionDto request) {
        MemberMission memberMission = memberMissionCommandService.addMissionToMember(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDto(memberMission));
    }
}
