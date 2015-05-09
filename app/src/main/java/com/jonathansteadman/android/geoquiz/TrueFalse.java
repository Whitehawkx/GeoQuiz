package com.jonathansteadman.android.geoquiz;

/**
 * Created by jonathan on 5/6/15.
 */
public class TrueFalse {
    private int mQuestion;

    private boolean mTrueQuestion;

    private boolean mUserCheated;

    public TrueFalse(int question, boolean trueQuestion, boolean userCheated) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mUserCheated = userCheated;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public boolean isUserCheated() {
        return mUserCheated;
    }

    public void setUserCheated(boolean userCheated) {
        mUserCheated = userCheated;
    }
}
