package com.yyk.service;

import com.yyk.entity.User;
import com.yyk.entity.UserExample;

import java.util.List;

public interface UserService {
    List<User> selectByExample(UserExample userExample);
}
