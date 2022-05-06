package com.example.ramayan.model;

public class AranyaKandModel {
    private int aranyaKandId;
    private String aranyaKandSanskrit;
    private String aranyakandHindi;

    public AranyaKandModel(String aranyaKandSanskrit, String aranyakandHindi) {
        this.aranyaKandSanskrit = aranyaKandSanskrit;
        this.aranyakandHindi = aranyakandHindi;
    }

    public int getAranyaKandId() {
        return aranyaKandId;
    }

    public void setAranyaKandId(int aranyaKandId) {
        this.aranyaKandId = aranyaKandId;
    }

    public String getAranyaKandSanskrit() {
        return aranyaKandSanskrit;
    }

    public void setAranyaKandSanskrit(String aranyaKandSanskrit) {
        this.aranyaKandSanskrit = aranyaKandSanskrit;
    }

    public String getAranyakandHindi() {
        return aranyakandHindi;
    }

    public void setAranyakandHindi(String aranyakandHindi) {
        this.aranyakandHindi = aranyakandHindi;
    }
}
