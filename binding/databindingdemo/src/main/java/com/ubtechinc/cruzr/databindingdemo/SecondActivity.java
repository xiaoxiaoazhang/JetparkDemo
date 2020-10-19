package com.ubtechinc.cruzr.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ubtechinc.cruzr.databindingdemo.databinding.ActivitySecondBinding;

import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        Map<String, String> text = new HashMap<>();
        text.put("1", "hello");
        binding.setMap(text);
        String key = "1";
        binding.setKey(key);
    }
}