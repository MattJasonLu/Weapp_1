package com.ljc.service.impl;

import com.ljc.mapper.UserMapper;
import com.ljc.pojo.User;
import com.ljc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public User get(User user) {
        return userMapper.get(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
