package com.fortress.demo.domain;

import javax.persistence.*;
import org.springframework.util.Assert;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_no;

    @Column(length = 100, nullable = false)
    private String user_id;

    @Column(length = 200, nullable = false)
    private String user_pwd;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_dept;

    @Column(nullable = false)
    private String user_job;

    @Column(nullable = false)
    private int user_level;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public User(int user_no, String user_id, String user_pwd, String user_name, String user_dept, String user_job, int user_level){
        this.user_no = user_no;
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_dept = user_dept;
        this.user_job = user_job;
        this.user_level = user_level;
    }
}
