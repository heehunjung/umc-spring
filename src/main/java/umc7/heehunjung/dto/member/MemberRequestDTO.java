package umc7.heehunjung.dto.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import umc7.heehunjung.domain.Gender;
import umc7.heehunjung.domain.Role;

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

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Gender gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        Role role;
    }
}
