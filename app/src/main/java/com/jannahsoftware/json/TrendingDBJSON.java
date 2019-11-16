package com.jannahsoftware.json;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.ITrnding;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.Model.Trending;
import com.jannahsoftware.moviedb.MainActivity;
import com.jannahsoftware.moviedb.TrendingActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class TrendingDBJSON implements ITrnding {

    @Override
    public void getTrending()
    {
        JsonObjectRequest trendingRequest = new JsonObjectRequest(Request.Method.GET, Conts.GET_TRENDING_ALL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

               try
               {

                   JSONArray jsonArray =  response.getJSONArray("results");

                   for (int i = 0; i < jsonArray.length(); i++)
                   {
                       JSONObject jsonObject = jsonArray.getJSONObject(i);


                       Trending trending = new Trending();

                       trending.setTitle(jsonObject.optString("title"));
                       trending.setPoster_path(jsonObject.optString("poster_path"));
                       trending.setBackdrop_path(jsonObject.optString("backdrop_path"));
                       trending.setOverview(jsonObject.optString("overview"));

                       trending.setRelease_date(jsonObject.optString("first_air_date"));
                       trending.setVote_average((jsonObject.optInt("vote_average")));
                       trending.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                       TrendingActivity.trendingList.add(trending);

                       Log.d("ARRAY", "onResponse: " + jsonObject.optString("title"));
                       Log.d("ARRAY", "onResponse: " + jsonObject.optString("poster_path"));
                       Log.d("Overview", "onResponse: " + jsonObject.optString("overview"));

                       Log.d("ARRAY", "onResponse: " + jsonObject.optString("first_air_date"));
                       Log.d("ARRAY", "onResponse: " + jsonObject.optInt("vote_average"));
                       Log.d("POP", "onResponse: " + Math.round(jsonObject.optDouble("popularity")));
                   }

                   TrendingActivity.adapter.notifyDataSetChanged();
               }catch (Exception x)
               {
                   x.printStackTrace();
               }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Conts.requestQueue.add(trendingRequest);
    }
}
