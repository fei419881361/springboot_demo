package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.jwt.MyJWT;
import com.example.demo.mapper.UserMapper;
import com.example.demo.request.PasswordLoginRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhanglf
 * @Date 2021/4/14 下午9:47
 */
@RestController("login")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
    /**
     * 账号密码登录
     * @return
     */
    @PostMapping("passwordLogin")
    public BaseResponse passwordLogin(@Valid PasswordLoginRequest loginRequest){
        logger.info("账号密码登录，email:{}", loginRequest.getEmail());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", loginRequest.getEmail());
        User user = userMapper.selectOne(wrapper);
        if (user == null) {
            logger.info("用户不存在");
            return new BaseResponse("404","用户不存在",null);
        }

        // TODO: 2021/4/14 密码加密

        if (user.getPwd().equals(loginRequest.getPassword())) {
            // 生成token
            String jwt = MyJWT.createJwt(user.getEmail(), user.getName(), null);
            logger.info("登录成功");
            return new SuccessResponse("登录成功", jwt);
        }else {
            logger.info("密码错误");
            // TODO: 2021/4/14 自定义业务异常编号
            return new BaseResponse("404", "用户密码错误", null);
        }
    }
}
