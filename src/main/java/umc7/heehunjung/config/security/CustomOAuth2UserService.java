package umc7.heehunjung.config.security;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umc7.heehunjung.domain.Gender;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Role;
import umc7.heehunjung.repository.MemberRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService  extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("loadUser");
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.warn(oAuth2User.toString());
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");

        String nickname = (String) properties.get("nickname");
        String userId = nickname + "@kakao.com"; // 임시 이메일 생성

        Member member = saveOrUpdateUser(nickname, userId);

        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("userId", userId);
        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "userId"  // email Principal로 설정
        );
    }

    private Member saveOrUpdateUser(String username, String nickname) {
        Member member = memberRepository.findByUserId(username)
                .orElse(Member.builder()
                        .userId(username)
                        .name(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                        .gender(Gender.MALE)  // 기본값 설정
                        .address("소셜로그인")  // 기본값 설정
                        .role(Role.USER)
                        .build());
        log.info(member.toString());
        return memberRepository.save(member);
    }
}
