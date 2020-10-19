package com.ubtechinc.cruzr.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import android.os.Bundle;

import com.ubtechinc.cruzr.databindingdemo.databinding.ActivityThirdBinding;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_third);

        ObservableArrayList<Object> user = new ObservableArrayList<>();
        user.add("Google");
        user.add("Inc.");
        user.add(17);
        binding.setUser(user);
    }
}