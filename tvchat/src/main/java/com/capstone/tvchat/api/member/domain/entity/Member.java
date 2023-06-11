package com.capstone.tvchat.api.member.domain.entity;

import com.capstone.tvchat.api.member.domain.enumerate.Authority;
import com.capstone.tvchat.common.domain.BaseEntity;
import com.capstone.tvchat.common.enumerate.Yn;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_nickname")
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "use_yn")
    private Yn useYn;

    @Builder(builderClassName = "of",builderMethodName = "of")
    public Member(Long id, String email, String password, String nickname, Authority authority, Yn useYn) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.authority = authority;
        this.useYn = useYn;
    }

    @Builder(builderClassName = "createBuilder", builderMethodName = "createBuilder")
    public static Member create(String email, String password, String nickname){
        return Member.of()
                .email(email)
                .password(password)
                .nickname(nickname)
                .useYn(Yn.Y)
                .authority(Authority.ROLE_USER)
                .build();
    }


    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }
}
