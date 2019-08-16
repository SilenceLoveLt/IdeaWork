package com.yyk.service.Impl;


import com.yyk.dao.UserMapper;
import com.yyk.entity.User;
import com.yyk.entity.UserExample;
import com.yyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userdao;

    @Override
    public List<User> selectByExample(UserExample userExample) {
        return userdao.selectByExample(userExample);
    }
}
