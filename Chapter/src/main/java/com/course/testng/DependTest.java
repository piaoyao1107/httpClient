package com.course.testng;

import org.testng.annotations.Test;

/**
 * 依赖测试
 * test2依赖于test1时，当test1失败，test2被忽略（ignore）
 */



public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }

}
