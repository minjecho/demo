package com.fortress.demo.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fortress.demo.domain.User;
import com.fortress.demo.dto.UserDTO;

import antlr.collections.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository UserRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 5;
    private static final int PAGE_USER_COUNT = 20;

    private UserDTO convertEntityToDto(User user){
        return UserDTO.builder()
            .user_no(user.getUser_no())
            .user_id(user.getUser_id())
            .user_pwd(user.getUser_pwd())
            .user_dept(user.getUser_dept())
            .user_job(user.getUser_job())
            .user_level(user.getUser_level())
            .build();
    }

    @Transactional
    public List<UserDTO> getUserList(Integer pageNum){
        Page<User> page = userRepository.findAll(PageRequest.of(
            pageNum - 1, PAGE_USER_COUNT, Sort.by(Sort.Direction.ASC, "user_no")));

        List<User> userEntities = page.getContent();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userEntities){
            userDTOList.add(this.convertEntityToDto(user));
        }

        return userDTOList;
    }
}
