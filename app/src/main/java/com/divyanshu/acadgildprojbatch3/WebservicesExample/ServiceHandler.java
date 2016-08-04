package com.divyanshu.acadgildprojbatch3.WebservicesExample;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Divyanshu on 04-08-2016.
 */
@SuppressWarnings("Deprecated")
public class ServiceHandler {

    static String response =null;
    public final static int GET = 1;
    public final static int POST = 2;

    public String makeServiceCall(String url, int  method){
        return this.makeServiceCall(url,method,null);
    }

    public String makeServiceCall(String url, int method, List<NameValuePair> params){

        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity  httpEntity = null;
            HttpResponse httpResponse = null;

            if(method == POST){
                HttpPost httpPost = new HttpPost(url);
                if(params!=null){
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }
                httpResponse = httpClient.execute(httpPost);
            }
            else if(method == GET){
                if(params!=null){
                    String paramString = URLEncodedUtils.format(params,"utf-8");
                    url +="?" +paramString; //ID
                }
                HttpGet httpGet= new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
            }

            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);


        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String newWay(String url, int method, List<NameValuePair> paramsL){
        String response = null;
        try{
            URL urlVal = new URL(url);
//            Map<String,Object> parms = new LinkedHashMap<>();
//            parms.put("userbame","SAI");



            HttpURLConnection conn = (HttpURLConnection)urlVal.openConnection();
            conn.setRequestMethod("GET");

            conn.setDoOutput(true);
           // conn.getOutputStream().write(p);


            if(conn.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int c; (c = in.read())>0;)
                sb.append((char)c);
             response = sb.toString();
            System.out.println("RESPONSE::::"+response);

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
