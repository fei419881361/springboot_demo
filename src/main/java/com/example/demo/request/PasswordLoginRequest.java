package com.example.demo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zhanglf
 * @Date 2021/4/14 下午9:54
 */
@Data
public class PasswordLoginRequest {
    @NotBlank
    private String password;
    @NotBlank
    private String email;
}
