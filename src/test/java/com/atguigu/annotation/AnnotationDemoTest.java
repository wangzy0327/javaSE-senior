package com.atguigu.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

    @Test
    public void getFieldType(){
        try {
            Person p1 = new Person();
            Class cl = p1.getClass();
            System.out.println("className : "+cl.getName());
            Field age = cl.getDeclaredField("age");
            System.out.println("field name : "+age.getName());
            Class<?> fieldType = age.getType();
            System.out.println("field type : "+fieldType.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Double d = 0.00d;
        System.out.println(d.toString());
    }

    @Test
    public void parseAnno(){
        try {
            //1.使用类加载器加载类
            Class c = Class.forName("com.atguigu.annotation.Person");
            //找到类上面的注解
            boolean isExist = c.isAnnotationPresent(MyAnnotation.class);
            if(isExist){
                //3.拿到注解实例
                MyAnnotation md = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
                System.out.println(md.value());
                //result
                //initial
            }
            //4.找到方法上的注解
            Method[] ms = c.getMethods();
            for(Method m : ms){
                boolean isMExist = m.isAnnotationPresent(MyAnnotation.class);
                if(isMExist){
                    MyAnnotation md = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
                    System.out.println(md.value());
                }
            }
            //另一种方式
            for(Method m : ms){
                Annotation[] as = m.getAnnotations();
                for(Annotation a : as){
                    if(a instanceof MyAnnotation){
                        MyAnnotation md = (MyAnnotation) a;
                        System.out.println(md.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseInheritedAnno(){
        try {
            //解析继承注解 子类
            //1.使用类加载器加载类
            Class c = Class.forName("com.atguigu.annotation.Student");
            //找到类上面的注解
            boolean isExist = c.isAnnotationPresent(MyAnnotation.class);
            if(isExist){
                //3.拿到注解实例
                MyAnnotation md = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
                System.out.println(md.value());
                //result 获取到了子类注解
                //initial
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

@MyAnnotation(value = "initial")
class Person{

    @MyAnnotation
    Integer age;

    @Deprecated
    public void eat(){
        System.out.println("吃饭");
    }
    public void walk(){
        System.out.println("走路");
    }
}

class Student extends Person{

    @Override
    public void walk(){
        super.walk();
    }

    @Override
    public void eat(){

    }
}
