/**
 * decription:
 *
 * @author:Administrator
 * @date:2019/8/6 21:33
 */

package com.li.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/servlet/WeatherServlet");

        //打开url
        URLConnection uc  = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) uc;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type","text/html;charset=UTF-8");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
       OutputStream out = uc.getOutputStream();
       out.write("".getBytes());
       int httpResponseCode = httpURLConnection.getResponseCode();
        String line = null;
       if(httpResponseCode == 200){
           BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
           while((line =br.readLine())!= null){
               System.out.println(line);
           }
       }

    }
}
