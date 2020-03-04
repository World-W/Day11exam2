package com.example.day11exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        iniView();
        getData();
    }

    protected abstract int getLayoutID();

    protected abstract void iniView();

    protected abstract void getData();
}

