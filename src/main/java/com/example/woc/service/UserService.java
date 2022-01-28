package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 信安小军
 * @create: 2022-01-15 01:22
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<Account> queryAll() {
        return userMapper.queryAll();
    }
    public Account queryByName(String username) {
        return userMapper.queryByName(username);
    }

    public Account queryById(Integer id) {
        return userMapper.queryById(id);
    }


    public boolean deleteUserById(String username) {
        return userMapper.deleteUserByName(username) > 0;
    }

    public boolean addUser(Account user) {
        return userMapper.addUser(user) > 0;
    }

}


//    //示例
//    public void test(String test) {
//        userMapper.test(test);
//    }

