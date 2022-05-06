package com.example.ramayan.model;

public class AyodhaKandModel {
    private int ayodhaId;
    private String ayodhakandSanskrit;
    private String ayodhaKamdHindi;

    public AyodhaKandModel(String ayodhakandSanskrit, String ayodhaKamdHindi) {
        this.ayodhakandSanskrit = ayodhakandSanskrit;
        this.ayodhaKamdHindi = ayodhaKamdHindi;
    }

    public int getAyodhaId() {
        return ayodhaId;
    }

    public void setAyodhaId(int ayodhaId) {
        this.ayodhaId = ayodhaId;
    }

    public String getAyodhakandSanskrit() {
        return ayodhakandSanskrit;
    }

    public void setAyodhakandSanskrit(String ayodhakandSanskrit) {
        this.ayodhakandSanskrit = ayodhakandSanskrit;
    }

    public String getAyodhaKamdHindi() {
        return ayodhaKamdHindi;
    }

    public void setAyodhaKamdHindi(String ayodhaKamdHindi) {
        this.ayodhaKamdHindi = ayodhaKamdHindi;
    }
}
