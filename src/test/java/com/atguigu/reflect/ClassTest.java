package com.atguigu.reflect;

import org.junit.Test;

public class ClassTest {

    /**
     * 一、关于Class的理解
     *
     * 1.Class是java中的一个类。此类不能直接调用其构造器，实现实例化的。
     * 2.java源文件 经过javac命令之后，就会生成一个或多个字节码文件。
     *   每一个字节码文件都对应着一个java类。我们使用java命令操作对应的字节码文件时，
     *   就会将此字节码文件对应的类加载到内存中。加载（使用类加载器）到内存（方法区缓存）中的java类，称为运行时类。
     *   此运行时类就作为Class的实例。
     *   换句话说，Class的实例就指向加载到内存中的一个运行时类。
     * 3.通常情况下，加载到内存中的运行时类就只有一份！
     *
     *
     * 二、Class实例的获取方式（4种）
     *
     */

    @Test
    public void test1() throws ClassNotFoundException {
        //方式1：调用运行时类的.class属性
        Class clazz1 = Person.class;

        Class clazz2 = String.class;
        Class clazz3 = int.class;

        //方式2：通过运行时类的对象调用getClass()
        Person p1 = new Person();
        Class clazz4 = p1.getClass();

        System.out.println(clazz1 == clazz4); //true

        //方式3：通过Class的静态方法forName()
        Class<?> clazz5 = Class.forName("com.atguigu.reflect.Person");

        System.out.println(clazz1 == clazz5); //true

        //方式4：通过类的加载器
        Class<?> clazz6 = ClassLoader.getSystemClassLoader().loadClass("com.atguigu.reflect.Person");
        System.out.println(clazz1 == clazz6);


    }

}
