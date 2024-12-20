package umc7.heehunjung.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc7.heehunjung.apiPayload.ApiResponse;
import umc7.heehunjung.domain.mapping.Review;
import umc7.heehunjung.dto.member.MemberRequestDTO;
import umc7.heehunjung.dto.member.MemberResponseDTO.MissionList;
import umc7.heehunjung.service.memberService.MemberCommandService;
import umc7.heehunjung.service.memberService.MemberQueryService;
import umc7.heehunjung.validation.annotation.CheckPage;
import umc7.heehunjung.converter.MemberConverter;
import umc7.heehunjung.dto.member.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API", description = "특정 멤버의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberResponseDTO.ReviewListsDTO> getReviewList(@PathVariable(name = "memberId") Long memberId,
                                                                       @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.reviewListDTO(reviewList));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "특정 멤버의 미션 목록 조회 API", description = "미션을 조회하고 싶은 멤버아이디를 경로변수로 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberResponseDTO.MissionList> getMissions(@PathVariable(name = "memberId") Long memberId,
                                                                  @CheckPage @RequestParam(name = "page") Integer page) {
        MissionList missionList = memberQueryService.getMissionList(memberId, page);
        return ApiResponse.onSuccess(missionList);
    }

    @PatchMapping("/mission")
    @Operation(summary = "미션 진행 상태 변경 API", description = "미션 상태를 변경하고 싶은 멤버아이디를 경로변수로 미션 아이디를 쿼리 파라미터로 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberResponseDTO.MemberMissionDto> updateState(@RequestBody MemberRequestDTO.MemberMissionDto request) {
        MemberResponseDTO.MemberMissionDto result = memberCommandService.updateMission(request);
        return ApiResponse.onSuccess(result);
    }
}
