package com.zzyy.rs.utils;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
public class BaiDuUtil {


    public static String getCity(String lat, String lng) {
        JsonElement obj = getLocationInfo(lat, lng).get("result");
        JsonObject jsonObject = obj.getAsJsonObject();
        JsonObject o1 = jsonObject.getAsJsonObject("addressComponent");
        JsonElement city = o1.get("city");
        JsonElement result = o1.get("district");
//                getJSONObject("result").getJSONObject("addressComponent");
        System.out.println(o1);
        System.out.println(city);
        System.out.println(result);
        return "";
    }

    public static JsonObject getLocationInfo(String lat, String lng) {
        String url = "http://api.map.baidu.com/geocoder/v2/?location=" + lat + ","
                + lng + "&output=json&ak=4rcKAZKG9OIl0wDkICSLx8BA"+"&pois=0";
        JsonObject returnData = new JsonParser().parse(getRequest(url)).getAsJsonObject();

        return returnData;
    }

    public static void main(String[] args) {
        System.out.println(BaiDuUtil.getCity("27.003584", "113.352761"));
    }

    public static String getRequest(String httpUrl, String... params) {
        StringBuilder resultData = new StringBuilder();
        URL url = null;
        try {

            String paramurl = sendGetParams(httpUrl, params);
            url = new URL(paramurl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConn = null;
        InputStreamReader in = null;
        BufferedReader buffer = null;
        String inputLine = null;
        if (url != null) {
            try {
                urlConn = (HttpURLConnection) url.openConnection();
                urlConn.setRequestMethod("GET");
                urlConn.setConnectTimeout(3000);
                in = new InputStreamReader(urlConn.getInputStream(),
                        "utf-8");
                buffer = new BufferedReader(in);
                if (urlConn.getResponseCode() == 200) {
                    while ((inputLine = buffer.readLine()) != null) {
                        resultData.append(inputLine);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (buffer != null) {
                        buffer.close();
                    }

                    if (in != null) {
                        in.close();
                    }

                    if (urlConn != null) {
                        urlConn.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultData.toString();
    }

    private static String sendGetParams(String reqURL, String... params) {
        StringBuilder sbd = new StringBuilder(reqURL);
        if (params != null && params.length > 0) {
            if (isexist(reqURL, "?")) {// 存在?
                sbd.append("&");
            } else {
                sbd.append("?");
            }
            for (int i = 0; i < params.length; i++) {
                String[] temp = params[i].split(":");
                sbd.append(temp[0]);
                sbd.append("=");
                sbd.append(urlEncode(temp[1]));
                sbd.append("&");

            }
            sbd.setLength(sbd.length() - 1);// 删掉最后一个
        }
        return sbd.toString();
    }

    // 查找某个字符串是否存在
    private static boolean isexist(String str, String fstr) {
        return str.indexOf(fstr) == -1 ? false : true;
    }

    private static String urlEncode(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder
                    .encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
