package com.ljc.service;

import com.ljc.pojo.User;

import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
public interface UserService {

    void add(User user);

    void delete(int id);

    User get(int id);

    User get(User user);

    void update(User user);

    List<User> list();

}
