package com.zzyy.rs.utils;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
public class GetLocationMsgUtils {

    public static String GetLocationMsg(double latitude,double longitude){

        String message = "";

        String url = String.format(

                "http://maps.google.cn/maps/api/geocode/json?latlng=%s,%s&language=CN",latitude,longitude);

        URL myURL = null;

        URLConnection httpsConn = null;

        try {

            myURL = new URL(url);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        try {

            httpsConn = (URLConnection) myURL.openConnection();

            if (httpsConn != null) {

                InputStreamReader insr = new InputStreamReader(

                        httpsConn.getInputStream(), "UTF-8");

                BufferedReader br = new BufferedReader(insr);

                String data = null;

                while ((data = br.readLine()) != null) {

                    message = message+data;

                }

                insr.close();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return message;

    }


    //在main函数调用步骤一中的方法：GetLocationMsg

    public final static void main(String[] args) {

        System.err.println(GetLocationMsg(28.7032246442,113.5781374462));
        JsonObject returnData = new JsonParser().parse(GetLocationMsg(28.25551,112.9994)).getAsJsonObject();
        JsonArray o1 = returnData.getAsJsonArray("results");
        JsonElement o2 = o1.get(1);
        JsonObject o3 = o2.getAsJsonObject();
        JsonArray o4 = o3.getAsJsonArray("address_components");
        JsonElement o5 = o4.get(1).getAsJsonObject().get("long_name");
        System.out.println(returnData);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o5);

    }
}
