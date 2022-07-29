package com.fortress.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fortress.demo.vo.UserVO;

@Mapper
public interface UserMapper {
    public List<UserVO> selectUserList() throws Exception;
    public List<UserVO> searchUserList(HashMap<String, Object> param);
    public UserVO getUser(String insertedID);
    
}
