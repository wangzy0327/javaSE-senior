package com.atguigu.annotation.practice;

import com.atguigu.annotation.practice.operation.Operate;
import com.atguigu.annotation.practice.pojo.Department;
import com.atguigu.annotation.practice.pojo.User;

public class Test {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setId(10);
        //查询id为10的用户

        User u2 = new User();
        u2.setUserName("lucky");
        //模糊查询用户名为lucky的用户

        User u3 = new User();
        u3.setEmail("liu@sina.com,zh@163.com,7777@qq.com");
        //查询邮箱为其中任意一个

        String sql1 = Operate.select(u1);
        String sql2 = Operate.select(u2);
        String sql3 = Operate.select(u3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

        Department dp1 = new Department();
        dp1.setId(1001);

        Department dp2 = new Department();
        dp2.setName("事业部");

        Department dp3 = new Department();
        dp3.setLeader("张三,李四,王五");

        String sql4 = Operate.select(dp1);
        String sql5 = Operate.select(dp2);
        String sql6 = Operate.select(dp3);

        System.out.println(sql4);
        System.out.println(sql5);
        System.out.println(sql6);

//        select * from user  where 1 = 1  and  id = 10
//        select * from user  where 1 = 1  and  user_name = 'lucky'
//        select * from user  where 1 = 1  and email in ( 'liu@sina.com' ,'zh@163.com' ,'7777@qq.com'  )

//        select * from department  where 1 = 1  and  id = 1001
//        select * from department  where 1 = 1  and  name = '事业部'
//        select * from department  where 1 = 1  and leader in ( '张三' ,'李四' ,'王五'  )


    }
}
