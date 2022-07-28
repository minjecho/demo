package com.fortress.demo.service;

import java.util.List;

import com.fortress.demo.vo.UserVO;

public interface UserService {
    List<UserVO> selectUserList() throws Exception;
    List<UserVO> searchUserList() throws Exception;
}
