package com.ubtechinc.cruzr.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ubtechinc.cruzr.daggerdemo.bean.A;
import com.ubtechinc.cruzr.daggerdemo.bean.MainApi;
import com.ubtechinc.cruzr.daggerdemo.dagger.SampleModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    /***
     * 第二步  使用Inject 注解，获取到A 对象的实例
     */
    @Inject
    A a;

//    @Named("dev")
//    @Inject
//    MainApi apiDev;
//
//    @Named("release")
//    @Inject
//    MainApi apiRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***
         * 第一步 添加依赖关系
         */
        //第一种方式
        DaggerMainComponent.create().inject(this);

        //第二种方式
//        DaggerMainComponent.builder().build().inject(this);

        /***
         * 第三步  调用A 对象的方法
         */
//        a.eat();

//        DaggerSampleComponent.builder()
//                .mainModule(new SampleModule(this))
////                .mainChildModule(new MainChildModule())
//                .build()
//                .inject(this);
//        apiDev.eat();
//        apiRelease.eat();
    }
}
