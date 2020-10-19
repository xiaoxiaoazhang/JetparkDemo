package com.ubtechinc.cruzr.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ubtechinc.cruzr.databindingdemo.bean.User;
import com.ubtechinc.cruzr.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        如果您要在 Fragment、ListView 或 RecyclerView 适配器中使用数据绑定项，您可能更愿意使用绑定类或 DataBindingUtil 类的 inflate() 方法，如以下代码示例所示：
//        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
        // or
//        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);

        User user = new User("Test", "User");
        binding.setUser(user);
    }
}
