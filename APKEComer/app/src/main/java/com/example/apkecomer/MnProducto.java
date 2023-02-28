package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.controlador.DProducto;

public class MnProducto extends AppCompatActivity {
    private GridView DataProd;
    private SearchView Schbus;
    private DProducto dpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_producto);

        DataProd = (GridView) findViewById(R.id.FrmProd_grid);
        Schbus = (SearchView) findViewById(R.id.FrmProd_schbus);
        try {
            dpro = new DProducto(this);
            dpro.Data=DataProd;
            dpro.getList("");
        } catch (Exception e)
        {getToast("Error Activity:"+e.getMessage());}

        Schbus.setOnQueryTextListener(getBuscar());
    }

    private SearchView.OnQueryTextListener getBuscar(){
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String buscar) {
                try {
                    dpro.getList(buscar);
                } catch (Exception e)
                {getToast("Error buscar:"+e.getMessage());}
                return false;
            }
        };
    }
    private void getToast(String men){
        Toast.makeText(this, men, Toast.LENGTH_SHORT).show();
    }
}