package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MnLogin extends AppCompatActivity {
    //private DPrueba1 dprue=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_login);
        //dprue = new DPrueba1(this);
    }

    public void Onclick_btnAcep(View v){
        //startActivity(new Intent(MnLogin.this,MnMenu.class));
        startActivity(new Intent(MnLogin.this,MnProducto.class));
        //dprue.getListDatos("8");
    }
}