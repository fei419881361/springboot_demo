package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlf
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/demo/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("getUserById")
    public User getUserById(String id) {
        User user = iUserService.getById(id);
        return user;
    }
}

