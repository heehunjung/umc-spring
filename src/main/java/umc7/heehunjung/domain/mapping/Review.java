package umc7.heehunjung.domain.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc7.heehunjung.domain.Member;
import umc7.heehunjung.domain.Restaurant;
import umc7.heehunjung.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 20)
    private String body;

    @ManyToOne
    @JoinColumn(name = "member_id")  // 외래 키 설정
    private Member member;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")  // 외래 키 설정
    private Restaurant restaurant;
}
