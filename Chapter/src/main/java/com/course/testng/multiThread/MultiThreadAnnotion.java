package com.course.testng.multiThread;

import org.testng.annotations.Test;


//多线程
public class MultiThreadAnnotion {

    @Test(invocationCount = 5,threadPoolSize = 3)
    public void test1(){
        System.out.println("test1");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
