package com.course.marketing;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Marketing {

    private String url;
    private ResourceBundle bundle;
    private String token;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test(priority = 1)
    public void testLogin() throws IOException {

        String uri = bundle.getString("test.login.uri");
        String testUrl = this.url + uri;

        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();


        //声明一个方法，就是post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("app_key","test");
        param.put("data","%7B%22mobile%22%3A%2218514506336%22%2C%22password%22%3A%22YTExMTExMQ%3D%3D%22%7D");
        param.put("format","json");
        param.put("name","gwy.base.login");
        param.put("sign","6C814BA51A6377565D18EC5C00C8D6C1");
        param.put("timestamp","2019-09-30 11:33:41");
        param.put("version","");


        //设置请求头信息:header
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;

        //设置cookies信息
//        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println("转换成json之前的响应："+result);

        //响应结果字符串转换成json
        JSONObject resultJson = new JSONObject(result);
        System.out.println("登陆接口返回响应为 >>> "+resultJson);

        //处理结果，判断
        String code =  resultJson.getString("code");
        Assert.assertEquals("0",code);
        if (code.equals("0")){
            JSONObject data = resultJson.getJSONObject("data");
            int userId = data.getInt("userId");
            token = data.getString("token");
            Assert.assertEquals(672,userId);
        }

//        JSONObject data = resultJson.getJSONObject("data");
//        int userId = data.getInt("userId");
//        token = data.getString("token");
//        Assert.assertEquals(672,userId);

    }

    //今日朋友圈-内容分类-查询
    @Test(priority = 2)
    public void testListCategory() throws IOException {

        String uri = bundle.getString("test.category.list.uri");
        String testUrl = this.url + uri;

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(testUrl);
        get.setHeader("content-type","application/json");
        get.setHeader("token",this.token);

        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");

        JSONObject resultJson = new JSONObject(result);
        System.out.println("查询分类列表接口返回响应为 >>> "+resultJson);

        int code = resultJson.getInt("code");
        String msg = resultJson.getString("msg");
        Assert.assertEquals(0,code);
        Assert.assertEquals("成功",msg);

    }

    //今日朋友圈-内容分类-添加分类
    @Test(priority = 3)
    public void testAddCategory() throws IOException {
        String uri = bundle.getString("test.category.add.uri");
        String testUrl = this.url + uri;

        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(testUrl);

        long nowDate =  new Date().getTime();
        String categoryName = "分类"+nowDate;
        JSONObject param = new JSONObject();
        param.put("name",categoryName);

        post.setHeader("content-type","application/json");
        post.setHeader("token",this.token);
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        HttpResponse response = client.execute(post);

        if(response.getStatusLine().getStatusCode()==200){

            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject resultJson = new JSONObject(result);
            System.out.println("添加分类接口返回响应为 >>> "+resultJson);

            int code = resultJson.getInt("code");
            String msg = resultJson.getString("msg");
            Assert.assertEquals(0,code);
            Assert.assertEquals("成功",msg);

        }


    }


}
