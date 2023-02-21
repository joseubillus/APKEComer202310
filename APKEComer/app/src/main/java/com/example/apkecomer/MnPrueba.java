package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.controlador.DPrueba1;

public class MnPrueba extends AppCompatActivity {
    private SearchView schbus;
    private ListView Lstprue;
    private DPrueba1 dpre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_prueba);

        Lstprue = (ListView) findViewById(R.id.FrmPrue_Lst);
        schbus =  (SearchView) findViewById(R.id.FrmPrue_txtbus);

        dpre = new DPrueba1(this);
        dpre.Lst = Lstprue;


        schbus.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                dpre.getListDatos(s);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
}