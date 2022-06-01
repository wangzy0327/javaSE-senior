package com.atguigu.reflect;

public class Person {
    //属性
    public String name;
    private int age;

    //构造器
    public Person(){
        System.out.println("Person() ... ");
    }

    public Person(int age){
        this.age = age;
    }

    private Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void walk(long mile){
        System.out.println("走了"+mile+"米的路程");
    }
}
