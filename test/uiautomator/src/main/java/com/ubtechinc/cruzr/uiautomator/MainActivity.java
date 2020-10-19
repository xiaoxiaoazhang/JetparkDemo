package com.ubtechinc.cruzr.uiautomator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.ubtechinc.cruzr.uiautomator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        activityMainBinding.text.append("\n");
        activityMainBinding.btnCreate.setOnClickListener(v -> activityMainBinding.text.append("btn create clicked\n"));
        activityMainBinding.btnUpdate.setOnClickListener(v -> activityMainBinding.text.append("btn update clicked\n"));
        activityMainBinding.btnDelete.setOnClickListener(v -> activityMainBinding.text.append("btn delete clicked\n"));
        activityMainBinding.getRoot().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                activityMainBinding.text.append(String.format("position(%f, %f) clicked\n", motionEvent.getRawX(), motionEvent.getRawY()));
                return false;
            }
        });
    }
}
