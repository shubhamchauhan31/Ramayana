package com.example.ramayan.model;

public class ValimikiRamayanaModel {
    private int id;
    private String sanskrit;
    private String hindi;

    public ValimikiRamayanaModel() {
    }

    public ValimikiRamayanaModel(String sanskrit, String hindi) {
        this.sanskrit = sanskrit;
        this.hindi = hindi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSanskrit() {
        return sanskrit;
    }

    public void setSanskrit(String sanskrit) {
        this.sanskrit = sanskrit;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    @Override
    public String toString() {
        return "ValimikiRamayanaModel{" +
                "sanskrit='" + sanskrit + '\'' +
                ", hindi='" + hindi + '\'' +
                '}';
    }
}
