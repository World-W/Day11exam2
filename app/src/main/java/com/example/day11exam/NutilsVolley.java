package com.example.day11exam;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;


public class NutilsVolley {

    private final RequestQueue requestQueue;

    private NutilsVolley(){
        requestQueue = Volley.newRequestQueue(App.getAction());
    }
    private static class Simap{
        private static final NutilsVolley INEAETC=new NutilsVolley();
    }
    public static NutilsVolley getInstance(){
        return Simap.INEAETC;
    }
    public interface Cobllack{
        void onSuccess(String json);
        void onFialues(String msg);
    }
    public void doGet(String url, final Cobllack cobllack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                cobllack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                cobllack.onFialues(error.getMessage());
            }
        });requestQueue.add(stringRequest);
    }
    public void doPost(String url, final HashMap<String,String>map, final Cobllack cobllack){
        new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                cobllack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                cobllack.onFialues(error.getMessage());
            }
        }){
            @Override
            protected Map getParams()  {
                return map;
            }
        };
    }
}
