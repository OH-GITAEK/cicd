package board.board.dto.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberRequest {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDto{
        private String name;
        @Schema(description = "사용자 이메일 주소", example = "email@example.com")
        private String email;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginDto{
        private String email;
        private String password;
    }
}
