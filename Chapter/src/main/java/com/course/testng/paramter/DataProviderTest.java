package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void dataProviderTest(String name,int age){
        System.out.println("name = "+name+";age = "+age);
    }


    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",11},
                {"wangwu",12}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1的方法***name = "+name+";age = "+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2的方法***name = "+name+";age = "+age);
    }


    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;

        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",21}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",22},
                    {"zhaoliu",23}
            };
        }

        return result;
    }
}
