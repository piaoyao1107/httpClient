package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 执行了");
    }

    /*
    * 忽略测试，即跳过该测试case
    */
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行了");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行了");
    }
}
