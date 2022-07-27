package com.fortress.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int user_no;

    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_dept;
    private String user_job;
    private int user_level;
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
