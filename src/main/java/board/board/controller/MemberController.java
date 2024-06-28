package board.board.controller;


import board.board.apiPayload.ApiResponse;
import board.board.apiPayload.code.status.SuccessStatus;
import board.board.dto.member.MemberRequest;
import board.board.dto.member.MemberResponse;
import board.board.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "회원가입 API", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/join")
    public ApiResponse<MemberResponse.MemberDto> join(@RequestBody MemberRequest.JoinDto joinDto){
        MemberResponse.MemberDto memberDto = memberService.join(joinDto);
        return ApiResponse.of(SuccessStatus.MEMBER_CREATED,memberDto);
    }

    @Operation(summary = "로그인 API", description = "사용자가 로그인할 수 있습니다.")
    @PostMapping("/login")
    public ApiResponse<MemberResponse.MemberDto> login(@RequestBody MemberRequest.LoginDto loginDto){
        MemberResponse.MemberDto memberDto = memberService.login(loginDto);
        return ApiResponse.of(SuccessStatus._OK,memberDto);
    }
}
