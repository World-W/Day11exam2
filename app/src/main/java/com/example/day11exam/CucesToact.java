package com.example.day11exam;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;


public class CucesToact extends LinearLayout {
    public CucesToact(Context context) {
        super(context);
    }

    public CucesToact(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CucesToact(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CucesToact(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
