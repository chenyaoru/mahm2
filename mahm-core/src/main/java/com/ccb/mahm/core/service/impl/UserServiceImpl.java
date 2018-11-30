package com.ccb.mahm.core.service.impl;

import com.ccb.mahm.common.utils.JwtUtils;
import com.ccb.mahm.core.dao.UserMapper;
import com.ccb.mahm.core.dto.UserDto;
import com.ccb.mahm.core.model.User;
import com.ccb.mahm.core.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private static final String encryptSalt = "F12839WhsnnEV$#23b";


    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = userMapper.selectUsers();
        PageInfo result = new PageInfo(user);
        return result;


    }

    @Override
    public String generateJwtToken(String username) {
        String salt = "12345";//JwtUtils.generateSalt();
        return JwtUtils.sign(username, salt, 3600); //生成jwt token，设置过期时间为1小时
    }

    @Override
    public UserDto getJwtTokenInfo(String username) {
        String salt = "12345";
        /**
         * @todo 从数据库或者缓存中取出jwt token生成时用的salt
         * salt = redisTemplate.opsForValue().get("token:"+username);
         */
        UserDto user = getUserInfo(username);
        user.setSalt(salt);
        return user;
    }

    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
    public UserDto getUserInfo(String userName) {
        UserDto user = new UserDto();
        user.setUserId(1L);
        user.setUsername("admin");
        user.setEncryptPwd(new Sha256Hash("123456", encryptSalt).toHex());
        return user;
    }

    @Override
    public List<String> getUserRoles(Long userId) {
        return Arrays.asList("admin");
    }
}
