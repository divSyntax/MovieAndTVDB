package com.jannahsoftware.json;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.ITrnding;

public class TrendingDBJSON implements ITrnding {

    @Override
    public void getTrending()
    {
        StringRequest trending = new StringRequest(Request.Method.GET, Conts.GET_TRENDING_ALL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
