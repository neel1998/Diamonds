package com.example.diamonds.diamonds;

/**
 * Created by Admin on 25-07-2018.
 */

public class Question {
    private String mID,mQuestion,mAnswer,mUser;
    public Question(String id,String question,String answer,String user){
        mID=id;
        mQuestion=question;
        mAnswer=answer;
        mUser=user;
    }
    public String getID(){return mID;}
    public String getQuestion(){return mQuestion;}
    public String getAnswer(){return mAnswer;}
    public String getUser(){return mUser;}
}
