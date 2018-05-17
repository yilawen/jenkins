package com.zack.controller;

import com.zack.bean.User;
import com.zack.repsonse.ResultDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public ResultDTO login(@RequestBody User user) {
        if (user.getUsername().equals("test")) return ResultDTO.success("成功");
        else return ResultDTO.fail("用户名或密码错误");
    }
}
