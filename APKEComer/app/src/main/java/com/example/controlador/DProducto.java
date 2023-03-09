package com.example.controlador;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.modelo.Producto;
import com.example.util.ADPProd;
import com.example.util.Mensaje;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DProducto implements IDao<Producto>{
    private AsyncHttpClient asyn=new AsyncHttpClient();
    private String url=Conexion.getUrl("SProducto.php");
    private List<Producto> array=new ArrayList<>();
    public GridView Data;
    private Context ct;
    private Mensaje men;

    public DProducto(Context c){
        this.ct=c;
        this.men=new Mensaje(c);
    }

    @Override
    public void getList(String bus) throws Exception {
        RequestParams params=new RequestParams();
        params.add("frm","list");
        params.add("txtbus",bus);
        asyn.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                men.MProgressBarDato();
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                men.MCloseProgBar(true);
                String resp=new String(responseBody);
                getJSON(resp);
                Data.setAdapter(new ADPProd(ct,array));
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                men.MCloseProgBar(true);
                getShow("Error Failure:", String.valueOf(error),0);
            }
        });
    }

    private void getJSON(String resp){
        try {
            array.clear();
            JSONArray json=new JSONArray(resp);
            for (int i = 0; i < json.length(); i++) {
                int cod=new Integer(json.getJSONObject(i).getString("cod"));
                String nom=json.getJSONObject(i).getString("nom");
                double pre=new Double(json.getJSONObject(i).getString("pre"));
                int stock=new Integer(json.getJSONObject(i).getString("stock"));
                String mar=json.getJSONObject(i).getString("mar");
                String cat=json.getJSONObject(i).getString("cat");
                String rank=json.getJSONObject(i).getString("rank");
                String carac=json.getJSONObject(i).getString("carac");
                String img=json.getJSONObject(i).getString("img");

                array.add(new Producto(cod,nom,pre,stock,mar,cat,rank,carac,img));
            }
        } catch (JSONException e)
        {getShow("Error JSON:",e.getMessage(),0);}
    }

    public void getShow(String men){
        new Mensaje(ct).getMensaje(men).show();
    }

    public void getShow(String titu,String men,Object ico){
        new Mensaje(ct).getMensaje(titu,men,ico).show();
    }

    private void getToast(String men){
        Toast.makeText(ct, men, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAdd(Producto obj) throws Exception {

    }

    @Override
    public void getUp(Producto obj) throws Exception {

    }

    @Override
    public void getDel() throws Exception {

    }

    @Override
    public Producto getItem(int f) {
        return array.get(f);
    }

    @Override
    public int getSize() {
        return array.size();
    }
}
