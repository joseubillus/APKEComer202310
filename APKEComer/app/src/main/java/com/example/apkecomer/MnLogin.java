package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MnLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_login);
    }

    public void Onclick_btnAcep(View v){
        startActivity(new Intent(MnLogin.this,MnMenu.class));
    }
}