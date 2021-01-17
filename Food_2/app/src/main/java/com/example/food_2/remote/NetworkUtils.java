package com.example.food_2.remote;

import android.net.Uri;

import com.example.food_2.Model.Nguoidung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetworkUtils {
    private  static final String NV_REGISTER_BASE_URL = "https://newfoodapp.000webhostapp.com/api/nguoidungs";

    public  static String Login(){

        try{
            Uri buildURI = Uri.parse(NV_REGISTER_BASE_URL).buildUpon()
                    .build();
            URL requestURL = new URL(buildURI.toString());
            return  callAPI(requestURL,"GET");
        }
        catch (MalformedURLException e){
            return null;
        }
    }
    public  static String Register(Nguoidung nguoidung){

        try{
            Uri buildURI = Uri.parse(NV_REGISTER_BASE_URL).buildUpon()
                    .appendQueryParameter("ten",nguoidung.getTen())
                    .appendQueryParameter("gmail",nguoidung.getGmail())
                    .appendQueryParameter("matkhau",nguoidung.getMatkhau())
                    .build();
            URL requestURL = new URL(buildURI.toString());
            return  callAPI(requestURL,"POST");
        }
        catch (MalformedURLException e){
            return null;
        }
    }
    public static String callAPI(URL requestURL, String method){
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod(method);
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            return convertISToString(inputStream);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String convertISToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
                if (builder.length() == 0) {
                    return null;
                }
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }
}
