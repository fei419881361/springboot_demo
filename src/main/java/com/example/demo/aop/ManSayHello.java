package com.example.demo.aop;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhanglf
 * @Date 2020/12/13 下午12:12
 */
public class ManSayHello implements HelloWorld{

    @Override
    public String say() {
        System.out.println("执行say()");
        return "hello man";
    }
}
