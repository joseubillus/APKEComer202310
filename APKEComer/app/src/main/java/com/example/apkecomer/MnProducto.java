package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.controlador.DProducto;

public class MnProducto extends AppCompatActivity {
    private GridView DataProd;
    private DProducto dpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_producto);

        DataProd =  (GridView) findViewById(R.id.FrmProd_grid);
        try {
            dpro = new DProducto(this);
            dpro.getList("");
        } catch (Exception e)
        {getToast("Error Activity:"+e.getMessage());}
    }
    private void getToast(String men){
        Toast.makeText(this, men, Toast.LENGTH_SHORT).show();
    }
}