package com.example.apkecomer;

import android.os.Bundle;

import com.example.util.Mensaje;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.example.apkecomer.databinding.ActivityMnDetaProductoBinding;

public class MnDetaProducto extends AppCompatActivity {

    private ActivityMnDetaProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMnDetaProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View root=binding.getRoot();

        TextView lblnom=(TextView) root.findViewById(R.id.FrmConfDePro_Lblnom);
        TextView lblpre=(TextView) root.findViewById(R.id.FrmConfDePro_Lblpre);

        if(this.getIntent().getExtras().getString("Cod")!=null){
            Bundle bundle=this.getIntent().getExtras();
            String cod=bundle.getString("Cod");
            String nom=bundle.getString("Nom");
            String pre=bundle.getString("Pre");

            lblnom.setText(""+nom);
            lblpre.setText(""+pre);
        }
    }
}