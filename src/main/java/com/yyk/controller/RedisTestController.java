package com.yyk.controller;

import com.yyk.entity.User;
import com.yyk.entity.UserExample;
import com.yyk.service.UserService;
import com.yyk.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(Url.REDIS_MANAGE)
public class RedisTestController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static String KEY = "YYK:LT:%s:%s";

    @Autowired
    @Qualifier("userService")
    private UserService userService;




    @RequestMapping(Url.SHOW)
    public String show(){
        return "redisTest";
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(Url.REDIS_SELECT)
    public List<User> findOne(Integer id) {
        String key = getKey();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            List<User> users = (List<User>) redisTemplate.opsForValue().get(key);
            return users;
        }
        // 从数据库取，并存回缓存
        UserExample example=new UserExample();
        UserExample.Criteria cri=example.createCriteria();
        cri.andUserNameLike("%"+"李"+"%");

        List<User> users = userService.selectByExample(example);
        // 放入缓存，并设置缓存时间
        redisTemplate.opsForValue().set(key, users, 2, TimeUnit.HOURS);
        List<User> list = (List<User>) redisTemplate.opsForValue().get(key);
        return list;
    }

    public String getKey(){
        return String.format(KEY,"123","456");
    }
}
