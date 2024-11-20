package umc7.heehunjung.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Mission;
import umc7.heehunjung.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);

    Optional<MemberMission> findByMemberAndMission(Member member, Mission mission);
}
