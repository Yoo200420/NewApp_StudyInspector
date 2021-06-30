package com.example.newapp;


import android.graphics.Color;

import com.nhn.android.naverlogin.data.OAuthLoginState;

import java.util.List;

public class User
{

    private String userId;
    private String platformType;
    private String name;
    private boolean manOrWoman;
    private int age;

    private String Access_Token;

    private String nickName;
    private String category;
    private String statusMessage;
    private String region;

    private Color backGroundColor;
    private List<String> listOfInspector;


    public User() {}

    public User(
            String userId,
            String platformType,
            String name,
            boolean manOrWoman,
            int age,
            String nickName,
            String category,
            String region
    )
    {
        this.userId = userId;
        this.platformType = platformType;
        this.name = name;
        this.manOrWoman = manOrWoman;
        this.age = age;
        this.nickName = nickName;
        this.category = category;
        //this.statusMessage = statusMessage;
        this.region = region;
        //this.backGroundColor = backGroundColor;
        //this.listOfInspector = listOfInspector;
    }

    public static User newInstance
            (String userId,
             String platformType,
             String name,
             boolean manOrWoman,
             int age,
             String nickName,
             String category,
             String region
            )
    {
        if (platformType=="GoogleUser")
            return new GoogleUser(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);

        else if(platformType=="NaverUser")
            return new NaverUser(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);

        else if(platformType=="KakaoUser")
            return new KakaoUser(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);

        else if(platformType=="FacebookUser")
            return new FacebookUser(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);
        else
            return new User();
    }


    public String getUserId() {return userId;}
    public String getPlatformType() {return platformType;}
    public String getName() {return name;}
    public boolean isManOrWoman() {return manOrWoman;}
    public int getAge() {return age;}
    public String getNickName() {return nickName;}
    public String getCategory() {return category;}
    public String getStatusMessage() {return statusMessage;}
    public String getRegion() {return region;}
    public Color getBackGroundColor() {return backGroundColor;}
    public List<String> getListOfInspector() {return listOfInspector;}

    @Override
    public String toString()
    {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", manOrWoman=" + manOrWoman +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", category='" + category + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", region='" + region + '\'' +
                ", backGroundColor=" + backGroundColor +
                ", listOfInspector=" + listOfInspector +
                '}';
    }

    private static class GoogleUser extends User
    {
        public GoogleUser(String userId, String platformType, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "GoogleUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}

    }

    private static class NaverUser extends User
    {
        private long expiresAt;
        private String refreshToken;
        private OAuthLoginState state;


        public NaverUser(String userId, String platformType, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "NaverUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class KakaoUser extends User
    {
        public KakaoUser(String userId, String platformType, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "KakaoUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class FacebookUser extends User
    {
        private String expiresIn;
        private String signedRequest;

        public FacebookUser(String userId, String platformType, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, platformType, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "FacebookUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

}

