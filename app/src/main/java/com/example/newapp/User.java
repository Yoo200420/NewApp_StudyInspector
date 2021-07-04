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


    public User(String platformType) {}



    public void setOthers
            (String userId,
             String name,
             boolean manOrWoman,
             int age,
             String nickName,
             String category,
             String region)
    {
        setUserId(userId);
        setName(name);
        setManOrWoman(manOrWoman);
        setAge(age);
        setNickName(nickName);
        setCategory(category);
        setRegion(region);
    }

    public static User newInstance(String platformType)
    {
        if (platformType=="GoogleUser")
            return new GoogleUser(platformType);

        else if(platformType=="NaverUser")
            return new NaverUser(platformType);

        else if(platformType=="KakaoUser")
            return new KakaoUser(platformType);

        else if(platformType=="FacebookUser")
            return new FacebookUser(platformType);
        else
            return new User("Itself");
    }

    private void setUserId(String userId) { this.userId = userId; }
    private void setName(String name) { this.name = name; }
    private void setManOrWoman(boolean manOrWoman) { this.manOrWoman = manOrWoman; }
    private void setAge(int age) { this.age = age; }
    private void setNickName(String nickName) { this.nickName = nickName; }
    private void setCategory(String category) { this.category = category; }
    private void setRegion(String region) { this.region = region; }

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
        private long expiresAt;
        private String refreshToken;

        public GoogleUser(String platformType) { super(platformType); }

        @Override
        public String toString()
        {return "GoogleUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}

    }

    private static class NaverUser extends User
    {
        private long expiresAt;
        private String refreshToken;
        private OAuthLoginState state;


        public NaverUser(String platformType)
        {
            super(platformType);
        }

        @Override
        public String toString()
        {return "NaverUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class KakaoUser extends User
    {
        private long expiresAt;
        private String refreshToken;

        public KakaoUser(String platformType)
        {
            super(platformType);
        }

        @Override
        public String toString()
        {return "KakaoUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class FacebookUser extends User
    {
        private String expiresIn;
        private String refreshToken;
        private String signedRequest;

        public FacebookUser(String platformType)
        {super(platformType);}

        @Override
        public String toString()
        {return "FacebookUser [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

}

