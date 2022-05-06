package com.example.ramayan.model;

public class BalkandFirstAdhyaModel {
    private int bId;
    private String balkandFirstAdhyaSanskrit;
    private String balkandFirstAdhyaHindi;

    public BalkandFirstAdhyaModel() {
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public BalkandFirstAdhyaModel(String balkandFirstAdhyaSanskrit, String balkandFirstAdhyaHindi) {
        this.balkandFirstAdhyaSanskrit = balkandFirstAdhyaSanskrit;
        this.balkandFirstAdhyaHindi = balkandFirstAdhyaHindi;
    }

    public String getBalkandFirstAdhyaSanskrit() {
        return balkandFirstAdhyaSanskrit;
    }

    public void setBalkandFirstAdhyaSanskrit(String balkandFirstAdhyaSanskrit) {
        this.balkandFirstAdhyaSanskrit = balkandFirstAdhyaSanskrit;
    }

    public String getBalkandFirstAdhyaHindi() {
        return balkandFirstAdhyaHindi;
    }

    public void setBalkandFirstAdhyaHindi(String balkandFirstAdhyaHindi) {
        this.balkandFirstAdhyaHindi = balkandFirstAdhyaHindi;
    }
}
