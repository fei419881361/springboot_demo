package com.example.demo.response;

/**
 * @author zhanglf
 * @Date 2021/4/14 下午10:13
 */
public class SuccessResponse extends BaseResponse{
    public SuccessResponse(String msg, Object data) {
        super("200",msg,data);
    }
}
