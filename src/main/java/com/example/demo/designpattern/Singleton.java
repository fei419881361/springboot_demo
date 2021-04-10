package com.example.demo.designpattern;

import java.security.Signature;

/**
 * @author zhanglf
 * @Date 2021/4/6 下午11:04
 */
// 双检锁
//public class Singleton {
//    private volatile static Singleton singleton;
//    private Singleton (){}
//    public static Singleton getSingleton() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//
//}
// 静态内部类
public class Singleton {
    private static class SingletonHolder {
        {
            System.out.println("sout1");
        }
        static {
            System.out.println("sout2");
        }
        private static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println(INSTANCE);
        }
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        System.out.println("////////");
        return SingletonHolder.INSTANCE;
    }
    public static void method(){
        System.out.println("1");
    }

    public static void main(String[] args) {
       Singleton.method();
//        Singleton.getInstance();
        System.out.println("test");
    }
}