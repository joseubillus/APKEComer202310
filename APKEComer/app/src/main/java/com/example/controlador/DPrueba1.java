package com.example.controlador;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DPrueba1 {
    private AsyncHttpClient asyn=new AsyncHttpClient();
    private String url="https://pokeapi.co/api/v2/pokemon";
    private Context ct;
    public ListView Lst;

    public DPrueba1(Context c) {
        this.ct=c;
    }

    public void getListDatos(String datos){
        RequestParams params=new RequestParams();
        params.add("limit",datos);
        params.add("offset","0");
        asyn.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp=new String(responseBody);
                //getToast("Lista:"+resp);
                getJSON(resp);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                getToast("Error de conexion:"+error);
            }
        });
    }

    public void getJSON(String resp){
        try {
            String nom="";
            ArrayAdapter adp=new ArrayAdapter(ct, android.R.layout.simple_list_item_1);
            JSONObject json = new JSONObject(resp);

            for (int i = 0; i < json.getJSONArray("results").length(); i++) {
                nom=" "+json.getJSONArray("results").getJSONObject(i).getString("name");
                adp.add(""+nom);
            }
            Lst.setAdapter(adp);
            //getToast("Nombre:" + nom);
        } catch (JSONException e) {
            getToast("Error JSON:"+e.getMessage());
        }
    }

    private void getToast(String men){
        Toast.makeText(ct, ""+men, Toast.LENGTH_SHORT).show();
    }
}
