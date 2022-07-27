package com.fortress.demo.dto;

import com.fortress.demo.domain.User;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
    private int userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userDept;
    private String userJob;
    private int userLevel;

    public User toEntity(){
        User user = User.builder()
            .userNo(userNo)
            .userId(userId)
            .userPwd(userPwd)
            .userName(userName)
            .userDept(userDept)
            .userJob(userJob)
            .userLevel(userLevel)
            .build();

        return user;
    }

    @Builder
    public UserDTO(int userNo, String userId, String userPwd, String userName
        , String userDept, String userJob, int userLevel){
            this.userNo = userNo;
            this.userId = userId;
            this.userPwd = userPwd;
            this.userName = userName;
            this.userDept = userDept;
            this.userJob = userJob;
            this.userLevel = userLevel;
    }
}
