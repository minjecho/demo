package com.fortress.demo.dto;

import com.fortress.demo.domain.User;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
    private int user_no;
    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_dept;
    private String user_job;
    private int user_level;

    public User toEntity(){
        User user = User.builder()
            .user_no(user_no)
            .user_id(user_id)
            .user_pwd(user_pwd)
            .user_name(user_name)
            .user_dept(user_dept)
            .user_job(user_job)
            .user_level(user_level)
            .build();

        return user;
    }

    @Builder
    public UserDTO(int user_no, String user_id, String user_pwd, String user_name
        , String user_dept, String user_job, int user_level){
            this.user_no = user_no;
            this.user_id = user_id;
            this.user_pwd = user_pwd;
            this.user_name = user_name;
            this.user_dept = user_dept;
            this.user_job = user_job;
            this.user_level = user_level;
    }
}
