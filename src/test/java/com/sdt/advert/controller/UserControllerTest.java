package com.sdt.advert.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserControllerTest {

    HttpClient httpClient;
    HttpPost httpPost;
    HttpGet httpGet;
    private String url;
    Map<String, String> headers = new HashMap<String, String>();

    private void initHttp(String action) {
        url = "http://192.168.66.88:8080" + action;
        System.out.println("base url:" + url);
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(url);
        httpGet = new HttpGet(url);
        headers.put("test", "test"); //按需增加
    }

    @Test
    public void queryExpireUser() throws Exception {
        String action = "/user/queryExpireUser";
        initHttp(action);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("userName", "admin"));
        list.add(new BasicNameValuePair("password", "test123"));
        list.add(new BasicNameValuePair("lastLoginDate", "-1"));
        httpPost.setEntity(new UrlEncodedFormEntity(list));
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String result = paraseResult(httpResponse);
        System.out.println("result:" + result);
    }


    protected String paraseResult(HttpResponse httpResponse) throws Exception {
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                String jsonContent = EntityUtils.toString(entity);
                return jsonContent;
            }
        } else {
            StatusLine statusLine = httpResponse.getStatusLine();
            System.out.println("status code = " + statusLine);
        }
        return null;
    }
}