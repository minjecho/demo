package com.fortress.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fortress.demo.domain.User;
import com.fortress.demo.dto.UserDTO;
import com.fortress.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

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

    // 전체 유저 리스트조회
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

    // 유저 1명의 정보 받기
    @Transactional
    public UserDTO getUser(String user_id){
        Optional<User> userWrapper = userRepository.findById(user_id);
        User user = userWrapper.get();

        UserDTO userDTO = UserDTO.builder()
                        .user_no(user.getUser_no())
                        .user_id(user.getUser_id())
                        .user_pwd(user.getUser_pwd())
                        .user_name(user.getUser_name())
                        .user_dept(user.getUser_dept())
                        .user_job(user.getUser_job())
                        .user_level(user.getUser_level()).build();
        
        return userDTO;
    }

    // 유저 정보 저장
    @Transactional
    public String saveUser(UserDTO userDTO){
        return userRepository.save(userDTO.toEntity()).getUser_id();
    }

    // 유저 탈퇴 처리
    @Transactional
    public void deleteUser(String user_id){
        userRepository.deleteById(user_id);
    }

    // 유저 검색
    // ID 검색
    @Transactional
    public List<UserDTO> searchID(String keyword){
        List<User> userEntities = userRepository.findById2(keyword);
        List<UserDTO> userDTOList = new ArrayList<>();

        if(userEntities.isEmpty()) return userDTOList;

        for(User user : userEntities){
            userDTOList.add(this.convertEntityToDto(user));
        }

        return userDTOList;
    }

    // 부서 검색
    @Transactional
    public List<UserDTO> searchDept(String keyword){
        List<User> userEntities = userRepository.findByDept(keyword);
        List<UserDTO> userDTOList = new ArrayList<>();

        if(userEntities.isEmpty()) return userDTOList;

        for(User user : userEntities){
            userDTOList.add(this.convertEntityToDto(user));
        }

        return userDTOList;
    }

    // 직급 검색
    @Transactional
    public List<UserDTO> searchJob(String keyword){
        List<User> userEntities = userRepository.findByJob(keyword);
        List<UserDTO> userDTOList = new ArrayList<>();

        if(userEntities.isEmpty()) return userDTOList;

        for(User user : userEntities){
            userDTOList.add(this.convertEntityToDto(user));
        }

        return userDTOList;
    }

    // 이름 검색
    @Transactional
    public List<UserDTO> searchName(String keyword){
        List<User> userEntities = userRepository.findByName(keyword);
        List<UserDTO> userDTOList = new ArrayList<>();

        if(userEntities.isEmpty()) return userDTOList;

        for(User user : userEntities){
            userDTOList.add(this.convertEntityToDto(user));
        }

        return userDTOList;
    }

    // 페이징 처리
    public Long getUserCount(){
        return userRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 전체 사용자 인원수
        Double userToatalCount = Double.valueOf(this.getUserCount());

        // 전체 사용자 기준으로 계산한 마지막 페이지 번호 계산(올림)
        Integer totalLastPageNum = (int)(Math.ceil((userToatalCount/PAGE_USER_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT) 
                                ? curPageNum + BLOCK_PAGE_NUM_COUNT : totalLastPageNum;

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0 ; val <= blockPageNum ; val++, idx++){
            pageList[idx] = val;
        }

        return pageList;
    }
}
