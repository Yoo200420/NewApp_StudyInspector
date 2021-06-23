package com.example.newapp;


import android.graphics.Color;

import java.util.List;

public class User
{
    private String userId;
    private String name;
    private boolean manOrWoman;
    private int age;

    private String nickName;
    private String category;
    private String statusMessage;
    private String region;

    private Color backGroundColor;
    private List<String> listOfInspector;


    public User() {}

    public User(
            String userId,
            String name,
            boolean manOrWoman,
            int age,
            String nickName,
            String category,
            String region
    )
    {
        this.userId = userId;
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
             String name,
             boolean manOrWoman,
             int age,
             String nickName,
             String category,
             String region
            )
    {
        if (category=="ElementarySchool")
            return new ElementarySchool(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="MiddleSchool_1")
            return new MiddleSchool_1(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="MiddleSchool_2")
            return new MiddleSchool_2(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="MiddleSchool_3")
            return new MiddleSchool_3(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="HighSchool_1")
            return new HighSchool_1(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="HighSchool_2")
            return new HighSchool_2(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="HighSchool_3")
            return new HighSchool_3(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="HighSchool_N")
            return new HighSchool_N(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="University")
            return new University(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="GraduateSchool")
            return new GraduateSchool(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="PublicOfficial")
            return new PublicOfficial(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="SpecializedJob")
            return new SpecializedJob(userId,name,manOrWoman,age,nickName,category,region);

        else if(category=="Others")
            return new Others(userId,name,manOrWoman,age,nickName,category,region);
        else
            return new User();
    }


    public String getUserId() {return userId;}
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

    private static class ElementarySchool extends User
    {
        public ElementarySchool(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "ElementarySchool [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}

    }

    private static class MiddleSchool_1 extends User
    {
        public MiddleSchool_1(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "MiddleSchool_1 [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class MiddleSchool_2 extends User
    {
        public MiddleSchool_2(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "MiddleSchool_2 [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class MiddleSchool_3 extends User
    {
        public MiddleSchool_3(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "MiddleSchool_3 [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class HighSchool_1 extends User
    {
        public HighSchool_1(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "HighSchool_1 [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class HighSchool_2 extends User
    {
        public HighSchool_2(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "HighSchool_2 [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class HighSchool_3 extends User
    {
        public HighSchool_3(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "HighSchool_3 [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class HighSchool_N extends User
    {
        public HighSchool_N(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "HighSchool_N [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class University extends User
    {
        public University(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "University [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class GraduateSchool extends User
    {
        public GraduateSchool(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "GraduateSchool [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class PublicOfficial  extends User
    {
        public PublicOfficial(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "PublicOfficial [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class SpecializedJob  extends User
    {
        public SpecializedJob(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "SpecializedJob [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

    private static class Others  extends User
    {
        public Others(String userId, String name, boolean manOrWoman, int age, String nickName, String category, String region)
        {super(userId, name,  manOrWoman,  age,  nickName,  category,  region);}

        @Override
        public String toString()
        {return "Others [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="+ hashCode() + "]";}
    }

}

