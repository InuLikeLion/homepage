package com.inulikelion.hompage.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="T_USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_SEQ")
    private Long userSeq;               // 구분자

    @Column(name="EMAIL_ID")
    private String emailId;             // 이메일주소

    @Column(name="PW")
    private String pw;                  // 비밀번호

    @Column(name="NAME")
    private String name;                // 이름

    @Column(name="STUDENT_ID")
    private int studentId;           // 학번

    @Column(name="NICK_NAME")
    private String nickName;            // 닉네임

    @Column(name="CARDINAL")
    private int cardinal;               // 기수

    @Column(name="AUTH")
    private String auth;                // 권한 (MASTER, SUPERIOIR, ROOKIE, ORIGIN, GENERAL)

    @Column(name="TOKEN")
    private String token;               // 로그인 토큰

    @Column(name="APPROVE_TF")
    private int approveTf;              // 회원가입 승인 여부

    @Column(name="INP_DATE")
    private LocalDateTime inpDate;      // 등록일

    @Column(name="MOD_DATE")
    private LocalDateTime modDate;      // 수정일


    @Builder
    public UserEntity(
            String emailId, String pw, String name,
            int studentId, String nickName, int cardinal,
            String auth, String token, int approveTf    ){
        this.emailId = emailId;
        this.pw = pw;
        this.name = name;
        this.studentId = studentId;
        this.nickName = nickName;
        this.cardinal = cardinal;
        this.auth = auth;
        this.token = token;
        this.approveTf = approveTf;
    }


    /* =======================================================
     * 입력, 수정 날짜 셋팅
     * ======================================================= */
    @PrePersist
    public void prePersist(){
        this.inpDate = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate(){
        this.modDate = LocalDateTime.now();
    }
}
