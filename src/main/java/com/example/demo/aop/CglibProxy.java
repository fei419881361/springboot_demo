package com.example.demo.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhanglf
 * @Date 2020/12/13 下午12:25
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理");

        Object ret = methodProxy.invokeSuper(o, objects);

        System.out.println("后置代理");

        return ret;
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        HelloWorld h = (HelloWorld) proxy.getProxy(HelloWorld.class);
        h.say();
    }
}
