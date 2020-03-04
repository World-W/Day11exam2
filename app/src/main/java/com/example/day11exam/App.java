package com.example.day11exam;

import android.app.Application;
import android.content.Context;

public class App extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    protected static  Context getAction(){
        return context;
    }
}
