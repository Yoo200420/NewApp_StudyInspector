package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LoginResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        Intent intent = getIntent();
        String accessToken=intent.getExtras().getString("AccessToken");
        Log.d("here", accessToken);

        NaverMemberProfile profile = new NaverMemberProfile(accessToken);
        profile.getNaverMemberProfile();
    }
}