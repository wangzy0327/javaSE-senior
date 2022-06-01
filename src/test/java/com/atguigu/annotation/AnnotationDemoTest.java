package com.atguigu.annotation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1、注解的概述
 *
 * 框架 = 注解 + 反射 + 设计模式
 *
 * 类似： 程序 = 数据结构 + 算法
 *
 * 2、java基础阶段常见的注解：
 *
 * @Override : 限定重写父类方法，该注解只能用于方法
 *
 * @Deprecated :用于表示所修饰的元素（类，方法等）已过时。通常是因为所修饰的结构危险或存在更好的选择
 *
 * @SuppressWarnings : 抑制编译器警告
 *
 * 3.如何自定义注解
 *   参照 @SuppressWarnings即可
 *
 * 4.元注解： 对现有的注解进行解释、修饰、说明作用的其他注解，就称为元注解
 *          @Retention
 *          @Target
 *          @Documented
 *          @Inherited
 *
 *
 */
public class AnnotationDemoTest {

    @Test
    public void query(){
        AnnotationDemo demo = new AnnotationDemo();
        demo.query("null");

        String s = "hello";
        System.out.println(s.equals("abc"));
    }

    @Test
    public void eat(){
        Person p1 = new Person();

        p1.eat();

        @SuppressWarnings({"rawtype"})
        List list = new ArrayList();
    }
}

@MyAnnotation(value = "initial")
class Person{

    @MyAnnotation
    int age;

    @Deprecated
    public void eat(){
        System.out.println("吃饭");
    }
    public void walk(){
        System.out.println("走路");
    }
}

class student extends Person{

    @Override
    public void walk(){
        super.walk();
    }

    @Override
    public void eat(){

    }
}
