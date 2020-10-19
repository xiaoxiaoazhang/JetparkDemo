package com.ubtechinc.cruzr.daggerdemo.bean;

import com.ubtechinc.cruzr.daggerdemo.MainActivity;

public class MainApi {

    private MainChildApi api;
    private MainActivity activity;
    private String url;

    public MainApi(MainChildApi api, MainActivity activity, String url) {
        this.api = api;
        this.activity = activity;
        this.url = url;
    }

    public void eat() {

    }
}
