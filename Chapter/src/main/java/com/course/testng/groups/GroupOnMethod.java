package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是server组的测试方法1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是server组的测试方法2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是client组的测试方法3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是client组的测试方法4");
    }


    @BeforeGroups("server")
    public void beforeGroupsOnMethod(){
        System.out.println("这是服务端组之前运行的方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnMethod(){
        System.out.println("这是服务端组之后运行的方法");
    }

}
