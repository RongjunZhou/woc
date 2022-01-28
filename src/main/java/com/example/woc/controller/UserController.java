package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 信安小军
 * @create: 2022-01-15 01:22
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    //这是一个示例,以POST方法提交数据
//    @PostMapping("/simple")
//    public String simple(String test) {
//        //按住ctrl键来看看具体调用的这个函数吧
//        userService.test(test);
//        return test;
//    }

    /**
     * 完成注册功能
     * 选做：对密码进行加密处理
     * Model Springmvc
     */
    @PostMapping("/register")
    public String register(Account account) {
        Account accountInstance=userService.queryByName(account.getUsername());
        //try catch
        try {
            if (accountInstance == null) {
                boolean bool = userService.addUser(account);
                if (bool) {
                    return "注册成功"+userService.queryByName(account.getUsername());
                } else {
                    return "用户名不能为空";//转注册界面
                }
            } else {
                return "该用户名已存在";//转注册界面
            }
        }catch (Exception e)
        {
            e.getStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 完成登录功能
     * @param account
     * @return 是否登录成功
     */
    @PostMapping("/login")
    public String login(Account account) {
        Account accountInstance;
        //分别实现id和用户名登录
        if(account.getUsername()!=null) {
            accountInstance = userService.queryByName(account.getUsername());
        }else{
            accountInstance = userService.queryById(account.getId());
        }
        try {
            if (accountInstance != null) {
                if (accountInstance.getPassword().equals(account.getPassword())) {
                    return "成功";//转主页
                } else {
                    return "密码不正确";//重回登陆界面
                }
            } else {
                return "该用户不存在";//不存在，注册
            }
        }catch (Exception e)
        {
            e.getStackTrace();
            return e.getMessage();
        }

    }
}
/**
 * 加密功能
 * 后序可以做重定向
 * session
 */

