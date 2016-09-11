package com.divyanshu.acadgildprojbatch3.GsonExmp;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Divyanshu on 29-08-2016.
 */
public class Parser_getGsonExmp {
   // public static GsonPOJO schema;
    Activity mActivity;
    String id;
    public Parser_getGsonExmp(Activity activity) {
        super();
        this.mActivity = activity;
        this.id= id;

        POSTForFetchingDATA("http://api.themoviedb.org/3/movie/upcoming?api_key=8496be0b2149805afa458ab8ec27560c");

        // TODO Auto-generated constructor stub
    }


    private String POSTForFetchingDATA(String urlValue) {
        try {

            URL url = new URL(urlValue);
//            Map<String, Object> params = new LinkedHashMap<>();
//            params.put("transporter_id", id);
//            StringBuilder postData = new StringBuilder();
//            for (Map.Entry<String, Object> param : params.entrySet()) {
//                if (postData.length() != 0) postData.append('&');
//                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//                postData.append('=');
//                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//            }
//            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // conn.setRequestProperty("Content-Type", "application/multipart/form-data");

            //conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
          //  conn.getOutputStream().write(postDataBytes);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.d("ERROR::::CODE", "http response code is " + conn.getResponseCode());
                return null;
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0; )
                sb.append((char) c);
            String response = sb.toString();
            System.out.println("Response SEARCH Result::::" + response);
            getGSONResult(response);

        } catch (UnknownHostException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        // 11. return result
        return "";
    }

    private void getGSONResult(String result) {
        Gson gson = new GsonBuilder().create();
        GsonPOJO schema = gson.fromJson(result, GsonPOJO.class);
        String title = schema.getResults().get(0).getTitle();

        Double popularity = schema.getResults().get(0).getPopularity();
        Integer vote_count = schema.getResults().get(0).getVoteCount();

        System.out.println("Values output:::::::"+title+" : "+popularity+" : "+vote_count);

        try {
//            String errorMessage = schema.getError();
            //  String code = schema.getStatus();


//            if (code.equalsIgnoreCase("0")) {
//                new Thread() {
//                    public void run() {
//                        mActivity.runOnUiThread(new Runnable() {
//                            public void run() {
//                                CustomDialog dialog = new CustomDialog(mActivity, "MESSAGE", schema.getError(), "RESPONSE");
//                                dialog.setCancelable(true);
//                                dialog.show();
//                            }
//                        });
//                    }
//                }.start();
//            }else {
//                new Thread() {
//                    public void run() {
//                        mActivity.runOnUiThread(new Runnable() {
//                            public void run() {
//                                CustomDialog dialog = new CustomDialog(mActivity, "MESSAGE", "Login Successfully", "RESPONSE");
//                                dialog.setCancelable(true);
//                                dialog.show();
//                            }
//                        });
//                    }
//                }.start();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
