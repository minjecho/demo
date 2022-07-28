package com.fortress.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortress.demo.mapper.UserMapper;
import com.fortress.demo.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserVO> selectUserList() throws Exception {
        return userMapper.selectUserList();
    }

    public List<UserVO> searchUserList() throws Exception {
        return userMapper.searchUserList();
    }
}
