package com.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.UserEntity;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    @Autowired
    private UserController userController;
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

    /**
     * Moc单元测试
     * @throws Exception
     */
    @Test
    public void queryUserById() throws Exception{
        request.addParameter("id","75");
        UserEntity user = userController.queryUserById(request);
        System.out.println("[queryUserById Test]");
        String expectedStr = "{\"id\":"+user.getId()+",\"name\":\""+user.getName()+"\",\"age\":"+user.getAge()+",\"state\":\""+user.getState()+"\",\"createDate\":\""+user.getCreateDate().toString()+"\"}";
        System.out.println("[expectedStr data]"+expectedStr);
        //String actualStr = "{\"id\":75,\"name\":\"renshuai5\",\"age\":25,\"state\":\"1\",\"createDate\":Wed Jul 10 21:41:20 CST 2019}";
        JSONObject actualJson = new JSONObject();
        actualJson.put("id",75);
        actualJson.put("name","renshuai5");
        actualJson.put("age",25);
        actualJson.put("state","1");
        actualJson.put("createDate","Wed Jul 10 21:41:20 CST 2019");

        System.out.println("[actualStr data]"+actualJson.toString());
        JSONAssert.assertEquals(expectedStr,actualJson.toString(),false);
    }

    /**
     * restful 单元测试，需先启动项目
     * @throws Exception
     */
    @Test
    public void queryUserList() throws Exception{
        JSONObject objSuccess = new JSONObject();
        objSuccess.put("state","1");
        objSuccess.put("error","调用成功");

        String data = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request requestok = new Request.Builder()
                .url("http://127.0.0.1:8080/queryUserList?pageNum=1&pageSize=1")
                .get()
                .build();
        Call call = okHttpClient.newCall(requestok);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                data = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject actualJson = new JSONObject();
        JSONArray actualArray = new JSONArray();
        actualJson.put("id",74);
        actualJson.put("name","renshuai4");
        actualJson.put("age",25);
        actualJson.put("state","1");
        actualJson.put("createDate",1562764434000L);
        actualArray.add(actualJson);

        System.out.println("[queryUserList Test]");
        System.out.println("[expectedStr data]"+data);
        System.out.println("[actualStr data]"+actualArray.toString());
        JSONAssert.assertEquals(data, actualArray.toString(), false);
    }

    /**
     * restful 单元测试，需先启动项目
     * @throws Exception
     */
    @Test
    public void insertUser() throws Exception{
        JSONObject objSuccess = new JSONObject();
        objSuccess.put("state","1");
        objSuccess.put("error","调用成功");

        String data = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request requestok = new Request.Builder()
                .url("http://127.0.0.1:8080/insertUser?name=renshuai3&age=25")
                .get()
                .build();
        Call call = okHttpClient.newCall(requestok);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                data = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[insertUser Test]");
        System.out.println("[data]"+data);
        JSONAssert.assertEquals(objSuccess.toString(), data, false);
    }
    /**
     * Mock 单元测试
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception{
        JSONObject objSuccess = new JSONObject();
        objSuccess.put("state","1");
        objSuccess.put("error","调用成功");

        String data = null;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request requestok = new Request.Builder()
                .url("http://127.0.0.1:8080/updateUser?name=renshuai3&age=25&id=76")
                .get()
                .build();
        Call call = okHttpClient.newCall(requestok);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                data = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[updateUser Test]");
        System.out.println("[data]"+data);
        JSONAssert.assertEquals(objSuccess.toString(), data, false);
    }


    /**
     * Mock 单元测试
     * @throws Exception
     */
    @Test
    public void deleteUser() throws Exception{
        request.addParameter("id","75");
        JSONObject expectedJson = userController.deleteUser(request);
        System.out.println("[deleteUser Test]");
        System.out.println("[expectedStr data]"+expectedJson.toString());
        JSONObject actualJson = new JSONObject();
        actualJson.put("state","1");
        actualJson.put("error","调用成功");
        System.out.println("[actualStr data]"+actualJson.toString());
        JSONAssert.assertEquals(expectedJson.toString(),actualJson.toString(),false);
    }

}