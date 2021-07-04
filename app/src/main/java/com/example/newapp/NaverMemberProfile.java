package com.example.newapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class NaverMemberProfile
{
    private String Access_Token;
    private String header;
    private final String apiURL = "https://openapi.naver.com/v1/nid/me";

    private String responseBody;



    public NaverMemberProfile(String access_Token)
    {
        Access_Token = access_Token;
        header = "Bearer " + Access_Token;
        Log.d("here", access_Token);
    }

    public void getNaverMemberProfile()
    {
        Map<String, String> requestHeaders = new HashMap<>();

        requestHeaders.put("Authorization", header);

        //responseBody = get(apiURL,requestHeaders);
        get(apiURL,requestHeaders);
        // String[] array= responseBody.split("\"");
        // Log.d("here",array[13].toString());
        //Log.d("here",array[17].toString());
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders)
    {
        HttpURLConnection con = connect(apiUrl);

        try
        {
            Log.d("here", "get");
            con.setRequestMethod("GET");



            for(Map.Entry<String, String> header :requestHeaders.entrySet())
            {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK)
            { // 정상 호출
                return readBody(con.getInputStream());
            }
            else
                { // 에러 발생
                return readBody(con.getErrorStream());
            }

        }

        catch (IOException e)
        {
            throw new RuntimeException("API 요청과 응답 실패", e);
        }

        finally
        {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl)
    {
        try
        {
            Log.d("here", "connect");
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        }

        catch (MalformedURLException e)
        {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        }

        catch (IOException e)
        {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body)
    {
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader))
        {
            Log.d("here", "readBody");
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null)
            {
                responseBody.append(line);
            }


            return responseBody.toString();
        }
        catch (IOException e)
        {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }


}
