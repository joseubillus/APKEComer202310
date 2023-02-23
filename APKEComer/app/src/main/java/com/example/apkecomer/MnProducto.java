package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MnProducto extends AppCompatActivity {
    private GridView DataProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_producto);

        DataProd =  (GridView) findViewById(R.id.FrmProd_grid);
        ArrayAdapter adp=new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        for (int i = 0; i < 20; i++)
            adp.add("Prod:"+i);
        DataProd.setAdapter(adp);
    }
}