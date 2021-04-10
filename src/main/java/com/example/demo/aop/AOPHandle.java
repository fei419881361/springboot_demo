package com.example.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhanglf
 * @Date 2020/12/13 下午12:13
 */
public class AOPHandle implements InvocationHandler {
    private Object obj;

    AOPHandle(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("前置代理");
        // 反射调用方法
        Object ret = method.invoke(obj, objects);
        System.out.println("后置代理");
        return ret;
    }

    public static void main(String[] args) {
        ManSayHello manSayHello = new ManSayHello();
        AOPHandle handle = new AOPHandle(manSayHello);
        HelloWorld h = (HelloWorld) Proxy.newProxyInstance(ManSayHello.class.getClassLoader(), new Class[]{HelloWorld.class}, handle);
        h.say();
        //System.out.println(h.say());
    }
}
