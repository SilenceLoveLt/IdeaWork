package com.yyk.controller;

import com.yyk.entity.User;
import com.yyk.entity.UserExample;
import com.yyk.service.UserService;
import com.yyk.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(Url.STREAM_MANAGE)
@Controller
public class StreamTestController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;



    @RequestMapping(Url.SHOW)
    public String show(){
        return "streamTest";
    }


    @ResponseBody
    @RequestMapping(Url.STREAM_FILTER)
    public List<User> filter(){
        UserExample example=new UserExample();
        UserExample.Criteria cri=example.createCriteria();
        cri.andUserNameLike("%"+"杨"+"%");
        example.or().andUserNameLike("%"+"李"+"%");
        List<User> users=userService.selectByExample(example);

        //使用Stream过滤集合
        List<User> list=users.stream().filter(u->"李婷".equals(u.getUserName())).collect(Collectors.toList());
        return list;
    }

    @ResponseBody
    @RequestMapping(Url.STREAM_FOREACH)
    public List<String> foreach(){
        UserExample example=new UserExample();
        UserExample.Criteria cri=example.createCriteria();
        cri.andUserNameLike("%"+"杨"+"%");
        example.or().andUserNameLike("%"+"李"+"%");
        List<User> users=userService.selectByExample(example);

        List<String> list=new ArrayList<String>();
        //使用stream中foreach循环
        users.stream().forEach(user -> list.add(user.getUserName()));
        return list;
    }
}
