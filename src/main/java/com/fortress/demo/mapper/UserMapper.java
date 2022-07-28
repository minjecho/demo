package com.fortress.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fortress.demo.vo.UserVO;

@Mapper
public interface UserMapper {
    List<UserVO> selectUserList() throws Exception;
}
