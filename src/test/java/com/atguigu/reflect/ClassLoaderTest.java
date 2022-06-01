package com.atguigu.reflect;

import org.junit.Test;

public class ClassLoaderTest {

    @Test
    public void test1(){
        //1.核心API 是使用引导类加载器加载的，但是在程序中该加载器无法直接获取到
        Class clazz1 = String.class;
        System.out.println(clazz1.getClassLoader());

        //ext下的扩展类加载器 略

        //2.自定义的类通常都是使用系统类加载器（或应用程序类加载器）加载的
        Class clazz2 = Person.class;
        System.out.println(clazz2.getClassLoader());
        //sun.misc.Launcher$AppClassLoader@18b4aac2

    }

    @Test
    public void test2(){
        Class clazz2 = Person.class;
        ClassLoader loader1 = clazz2.getClassLoader(); //获取到系统类加载器
        System.out.println(loader1);
        //sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader loader2 = loader1.getParent();  //获取了扩展类加载器
        System.out.println(loader2);
        //sun.misc.Launcher$ExtClassLoader@54bedef2

        ClassLoader loader3 = loader2.getParent(); //获取引导类加载器的操作，只不过操作失败
        System.out.println(loader3);
        //null
    }
}
