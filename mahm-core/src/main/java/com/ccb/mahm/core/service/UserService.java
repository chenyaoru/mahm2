package com.ccb.mahm.core.service;

import com.ccb.mahm.core.dto.UserDto;
import com.ccb.mahm.core.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    String generateJwtToken(String username);

    UserDto getJwtTokenInfo(String username);

    UserDto getUserInfo(String username);

    List<String> getUserRoles(Long userId);



}
