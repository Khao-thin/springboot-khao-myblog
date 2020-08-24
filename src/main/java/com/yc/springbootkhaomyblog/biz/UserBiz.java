package com.yc.springbootkhaomyblog.biz;

import com.yc.springbootkhaomyblog.domain.User;
import com.yc.springbootkhaomyblog.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBiz {
    @Resource
    private UserMapper userMapper;

    public void register(User user) throws BizException {
        if (userMapper.countByAccount(user.getAccount())>0){
            throw new BizException("该用户已存在");
        }
        userMapper.insert(user);
    }

    public User login(User user) throws BizException {
        User user1 = userMapper.selectByLogin(user);
        if (user1==null){
            throw new BizException("用户名或密码错误");
        }
        return user1;
    }
}
