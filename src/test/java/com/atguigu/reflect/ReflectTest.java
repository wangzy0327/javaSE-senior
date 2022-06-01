package com.atguigu.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    /**
     * 总结1：反射能做什么？
     *
     * 创建指定运行时类的对象
     * 调用类中指定的结构：构造器、属性、方法（即使相应结构的访问权限比较小，仍然是可以访问的）
     *
     * 总结2：暴力反射机制与类的封装性是否矛盾？为什么？
     *  不矛盾
     *    反射：能不能调用相关结构的问题。
     *    封装性：是否建议调用相关结构的问题。
     *
     *
     *
     * 总结：java中有哪几种方式用于创建对象呢？
     *    1. new + 构造器的方式
     *         扩展： xxx类的静态方法、 xxx Factory类的静态方法、xxxBuilder类的静态方法 (封装了构造器)
     *
     *    2. 通过反射
     *
     *    3.调用Object类的clone()方法：（要求：此clone()方法的调用者实现cloneable接口）
     *
     *    4.反序列化过程：将对象的二进制流还原为内存中的一个java对象
     *
     *
     */

    //使用反射之前
    @Test
    public void test1(){
        //1.创建类的对象
        Person p1 = new Person();
        System.out.println(p1);

        //2.通过“对象.属性”的方式，调用对象的实例变量
        p1.name = "巫长青";
        System.out.println(p1.name);
        //3.通过“对象.方法”的方式，调用对象的实例方法
        p1.eat();

//        Person() ...
//        com.atguigu.reflect.Person@32a1bec0
//         巫长青
//        吃饭

        //说明：在Person类的外部，不能调用Person类中声明为private权限的结构

    }

    //使用反射
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //1.创建类的对象 : 通过反射
        Class clazz = Person.class;
        Person person = (Person)clazz.newInstance();
        System.out.println(person);

        //2.通过反射的方式，调用对象的实例变量
        Field nameField = clazz.getField("name");
        nameField.set(person,"巫长青");
        System.out.println(nameField.get(person));

        //3.通过反射的方式，调用对象的实例方法
        Method eat = clazz.getMethod("eat");
        eat.invoke(person);

//        Person() ...
//        com.atguigu.reflect.Person@32a1bec0
//        巫长青
//        吃饭

    }


}
