package com.example.bsaia.RestAPI_Examples;

public class MyModelClass {
    //ye hmne https://codebeautify.org/json-to-java-converter# yaha sy convert..
    //kar kay ye model class bnae ha check ss#1164
    private float userId;
    private float id;
    private String title;
    private String body;

    public MyModelClass(float userId, float id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    // Getter Methods

    public float getUserId() {
        return userId;
    }

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    // Setter Methods

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
