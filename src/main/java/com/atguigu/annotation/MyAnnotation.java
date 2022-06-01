package com.atguigu.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解
 * 1.内部声明了一个value属性，是String类型的
 * 2.除此之外，我们在注解中可以声明的成员变量的类型包括
 *   八种基本数据类型、String类型、Class类型、enum类型、Annotation类型数组
 *
 * 3.可以在声明完属性之后，赋默认值 default
 *
 * 4.我们在自定义注解以后，就可以在相应的需要的位置进行使用。
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,METHOD,PACKAGE,CONSTRUCTOR,FIELD,LOCAL_VARIABLE})
@Inherited
public @interface MyAnnotation {

    //相当于变量
    String value() default "abc";
}
