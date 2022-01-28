package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: 信安小军
 * @create: 2022-01-15 04:19
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    //请仿照 User 补充 Admin 的三层架构并完成接口
    @Autowired
    UserService userService;
    /**
     * 获取当前的账户总数
     * @return
     */
    @GetMapping("/getAmount")
    public Integer getAmountOfAccounts(){
        List<Account> accounts = userService.queryAll();
        return accounts.size();
    }

    /**
     * 根据用户名删除账户
     * @param username
     */
    @GetMapping("/deleteAccount")

    public String deleteAccount(String username) {

        boolean isSuccess = userService.deleteUserById(username);
        if (isSuccess) {
            return "成功";
        } else {
            return "失败";
        }
    }

}
