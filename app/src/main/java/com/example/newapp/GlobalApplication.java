package com.example.newapp;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application
{
    private static GlobalApplication instanceOfGlobalApplication;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instanceOfGlobalApplication =this;

        KakaoSdk.init(this,"744ef5fe8925cf348464ec48e8bdfbed");
    }
}
