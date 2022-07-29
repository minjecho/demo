package com.fortress.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortress.demo.mapper.UserMapper;
import com.fortress.demo.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVO> selectUserList() throws Exception {
        return userMapper.selectUserList();
    }

    @Override
    public List<UserVO> searchUserList(int type, String keyword) throws Exception {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("keyword", keyword);
        return userMapper.searchUserList(param);
    }
}
