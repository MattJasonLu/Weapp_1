package com.ljc.mapper;

import com.ljc.pojo.User;

import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
public interface UserMapper {

    public void add(User category);

    public void delete(int id);

    public User get(int id);

    public User get(User user);

    public void update(User user);

    public List<User> list();

    public int count();

}
