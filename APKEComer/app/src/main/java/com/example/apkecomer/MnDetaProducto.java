package com.example.apkecomer;

import android.os.Bundle;

import com.example.controlador.Conexion;
import com.example.util.Mensaje;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.apkecomer.databinding.ActivityMnDetaProductoBinding;
import com.squareup.picasso.Picasso;

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
        RatingBar ratng=(RatingBar) root.findViewById(R.id.FrmConfDePro_Rbar);
        ImageView Imagen=(ImageView) root.findViewById(R.id.FrmDeProd_Img);
        TextView LblDesc=(TextView) root.findViewById(R.id.FrmConfDePro_LblDesc);

        if(this.getIntent().getExtras().getString("Cod")!=null){
            Bundle bundle=this.getIntent().getExtras();
            String cod=bundle.getString("Cod");
            String nom=bundle.getString("Nom");
            String pre=bundle.getString("Pre");
            String ratbar=bundle.getString("Ratg");
            String img=bundle.getString("Img");
            String desc=bundle.getString("Car");

            lblnom.setText(""+nom);
            lblpre.setText(""+pre);
            ratng.setRating(new Float(ratbar));
            LblDesc.setText(""+desc);
            Picasso.get().load(Conexion.getUrlImg(img)).into(Imagen);
        }
    }
}