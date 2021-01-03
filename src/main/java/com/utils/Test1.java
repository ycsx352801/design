package com.utils;

import com.bean.User;

import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws Exception{
        //反射
        User user=new User();
        //user.setUser_name("king");
        //User.java--Javac User.class---类加载---(User.class文件)JVM
        //要向操作User.class字节码文件，Class(代表虚拟机xxx.class) Class<User> userClass
        //获取到Class<User>,就能操作User类中的所有元素 构造器，方法，属性
        //调用构造方法创建对象，对象属性赋值，调用对象的方法
        //获取字节码文件时所有反射的入口
        Class<User> userClass=User.class;
        //newInstance调用User类的默认无参构造方法创建User类型的实例对象
        User user1=(User)userClass.newInstance();
        //获取到setUser_name方法
        Method setUsername=userClass.getMethod("setUser_name",String.class);
        //调用setUser_name方法给User对象赋值username
        //user.setUser_name("jerry")
        setUsername.invoke(user1,"jerry");
        System.out.println(user1);
    }
}
