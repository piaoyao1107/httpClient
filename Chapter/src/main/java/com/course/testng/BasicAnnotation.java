package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本的注解，把方法标记为测试用例
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod这是在测试用例之前执行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是在测试用例之后执行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在全部测试用例之前执行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在全部测试用例之后执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
