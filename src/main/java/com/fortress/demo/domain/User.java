package com.fortress.demo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userDept;
    private String userJob;
    private int userLevel;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public User(Long id, int userNo, String userId, String userPwd, String userName, String userDept, String userJob, int userLevel){
        this.id = id;
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userDept = userDept;
        this.userJob = userJob;
        this.userLevel = userLevel;
    }
}
