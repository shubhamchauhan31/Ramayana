package com.example.ramayan.model;

public class MyFavModel {
    private int fId;
    private String fSanskrit;
    private String fHindi;

    public MyFavModel() {
    }

    public MyFavModel( String fSanskrit, String fHindi) {
        this.fSanskrit = fSanskrit;
        this.fHindi = fHindi;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfSanskrit() {
        return fSanskrit;
    }

    public void setfSanskrit(String fSanskrit) {
        this.fSanskrit = fSanskrit;
    }

    public String getfHindi() {
        return fHindi;
    }

    public void setfHindi(String fHindi) {
        this.fHindi = fHindi;
    }
}
