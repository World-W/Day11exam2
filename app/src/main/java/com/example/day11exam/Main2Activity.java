package com.example.day11exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends BaseActivity {

    private TextView son;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main2;
    }

    @Override
    protected void iniView() {
        son = findViewById(R.id.son);
    }

    @Override
    protected void getData() {
        /*Intent intent = getIntent();
        String aa = intent.getStringExtra("aa");
        son.setText(aa);
        String string = son.getText().toString();
        Log.i("xxx","调用"+string);
        Toast.makeText(this, aa, Toast.LENGTH_SHORT).show();*/
        Intent intent = getIntent();
        String aa = intent.getStringExtra("aa");
        son.setText(aa);

    }
}
