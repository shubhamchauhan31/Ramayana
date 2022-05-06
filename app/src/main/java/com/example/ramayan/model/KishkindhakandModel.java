package com.example.ramayan.model;

public class KishkindhakandModel {
    private int kishkindhakandId;
    private String kishkindhakandSanskrit;
    private String kishkindhakandHindi;

    public KishkindhakandModel(String kishkindhakandSanskrit, String kishkindhakandHindi) {
        this.kishkindhakandSanskrit = kishkindhakandSanskrit;
        this.kishkindhakandHindi = kishkindhakandHindi;
    }

    public int getKishkindhakandId() {
        return kishkindhakandId;
    }

    public void setKishkindhakandId(int kishkindhakandId) {
        this.kishkindhakandId = kishkindhakandId;
    }

    public String getKishkindhakandSanskrit() {
        return kishkindhakandSanskrit;
    }

    public void setKishkindhakandSanskrit(String kishkindhakandSanskrit) {
        this.kishkindhakandSanskrit = kishkindhakandSanskrit;
    }

    public String getKishkindhakandHindi() {
        return kishkindhakandHindi;
    }

    public void setKishkindhakandHindi(String kishkindhakandHindi) {
        this.kishkindhakandHindi = kishkindhakandHindi;
    }
}
