package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {


    //timeOut=3000，预期结果3s

    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
