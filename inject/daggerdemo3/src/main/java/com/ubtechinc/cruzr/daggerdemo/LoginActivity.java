package com.ubtechinc.cruzr.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject
    LoginViewModel loginViewModel;

    // Reference to the Login graph
    LoginComponent loginComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creation of the login graph using the application graph
        loginComponent = ((MainApp) getApplicationContext())
                .appComponent.loginComponent().create();

        // Make Dagger instantiate @Inject fields in LoginActivity
        loginComponent.inject(this);

        // Now loginViewModel is available

        setContentView(R.layout.activity_login);
    }
}