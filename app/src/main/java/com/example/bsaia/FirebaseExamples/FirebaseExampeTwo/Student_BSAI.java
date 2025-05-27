package com.example.bsaia.FirebaseExamples.FirebaseExampeTwo;

public class Student_BSAI {
    String Name,Picture;

    public Student_BSAI() {

    }
    public Student_BSAI(String name, String picture) {
        Name = name;
        Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }
}
