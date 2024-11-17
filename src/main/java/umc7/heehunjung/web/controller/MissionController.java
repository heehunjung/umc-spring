package umc7.heehunjung.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc7.heehunjung.apiPayload.ApiResponse;
import umc7.heehunjung.domain.mapping.MemberMission;
import umc7.heehunjung.repository.MissionRepository;
import umc7.heehunjung.service.MemberMissionService.MemberMissionCommandService;
import umc7.heehunjung.web.converter.MemberMissionConverter;
import umc7.heehunjung.web.dto.MemberMissionResponseDto;
import umc7.heehunjung.web.dto.mission.MissionRequestDto;
import umc7.heehunjung.web.dto.mission.MissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    public final MissionRepository missionRepository;
    public final MemberMissionCommandService memberMissionCommandService;
    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDto.memberMission> addMission(@RequestBody MissionRequestDto.addMissionRequestDto request) {
        MemberMission memberMission = memberMissionCommandService.addMissionToMember(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDto(memberMission));
    }
}
