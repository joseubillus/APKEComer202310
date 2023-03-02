package com.example.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apkecomer.R;
import com.example.controlador.Conexion;
import com.example.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ADPProd extends BaseAdapter {
    private List<Producto> data=new ArrayList<>();
    private Context ct;

    public ADPProd(Context c){
        this.ct=c;
    }

    public ADPProd(Context c, List obj){
        this.ct=c;
        this.data=obj;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Producto getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).hashCode();
    }

    public void getAdd(Producto obj){
        data.add(obj);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root=view;
        if(root==null){
            LayoutInflater inf=(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            root = inf.inflate(R.layout.conf_list_producto,viewGroup,false);
        }
        TextView Lblnom=(TextView) root.findViewById(R.id.FrmCProd_Lblnom);
        TextView Lblpre=(TextView) root.findViewById(R.id.FrmCProd_Lblpre);
        ImageView Img=(ImageView) root.findViewById(R.id.FrmCProd_Img);

        Producto pro=getItem(i);
        Lblnom.setText(""+pro.getNom());
        Lblpre.setText("S/."+pro.getPre());
        Picasso.get().load(Conexion.getUrlImg(pro.getImg())).into(Img);
        return root;
    }
}
