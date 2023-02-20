package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.controlador.DPrueba1;

public class MnPrueba extends AppCompatActivity {
    private ListView Lstprue;
    private DPrueba1 dpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_prueba);

        Lstprue = (ListView) findViewById(R.id.FrmPrue_Lst);
        dpre = new DPrueba1(this);
        dpre.Lst = Lstprue;
        dpre.getListDatos("100");
    }
}