package com.example.kirito.phonedestination;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kirito on 2016.10.06.
 */

public class Http {

    public static String getDataFromUrl(String path){
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();

        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(8000);
            connection.setConnectTimeout(8000);
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String s = "";
            while ((s = br.readLine()) != null){
                sb.append(s);
            }
            br.close();
            if (connection != null){
                connection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
