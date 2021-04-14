package com.example.demo.response;

import lombok.Data;

/**
 * @author zhanglf
 * @Date 2021/4/14 下午9:51
 */
@Data
public class BaseResponse {
    private String code;
    private String msg;
    private Object data;


    public BaseResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
