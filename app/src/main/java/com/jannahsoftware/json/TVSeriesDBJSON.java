package com.jannahsoftware.json;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.ITVSeries;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.Model.TVSeries;
import com.jannahsoftware.moviedb.MainActivity;
import com.jannahsoftware.moviedb.PopularTVShows;
import com.jannahsoftware.moviedb.R;
import com.jannahsoftware.moviedb.SearchMovies;
import com.jannahsoftware.moviedb.SearchTVShows;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class TVSeriesDBJSON implements ITVSeries
{

    public TVSeriesDBJSON()
    {

    }

    @Override
    public void GetAllPopularTVSeries()
    {
        StringRequest getall_tvseries = new StringRequest(Request.Method.GET, Conts.GET_ALL_POPULAR_TVSERVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);

                        TVSeries tvSeries = new TVSeries();

                        tvSeries.setName(jsonObject.getString("name"));
                        tvSeries.setPoster_path(jsonObject.getString("poster_path"));
                        tvSeries.setBackdrop_path(jsonObject.getString("backdrop_path"));
                        tvSeries.setOverview(jsonObject.getString("overview"));

                        tvSeries.setFirst_air_date(jsonObject.getString("first_air_date"));
                        tvSeries.setVote_average(jsonObject.getInt("vote_average"));
                        tvSeries.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                        PopularTVShows.tvSeriesList.add(tvSeries);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("name"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("first_air_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
                    }

                    PopularTVShows.adapter.notifyDataSetChanged();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getall_tvseries);
    }

    @Override
    public void GetAiringTodayTVSeries()
    {
        StringRequest getall_airing_tvseries = new StringRequest(Request.Method.GET, Conts.GET_ALL_TV_AIRING_TODAY_TVSERVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("TVTODAY", "onResponse: " + jsonObject.getString("name"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getall_airing_tvseries);
    }

    @Override
    public void GetTopRatedTVSeries()
    {
        StringRequest getall_toprated_tvseries = new StringRequest(Request.Method.GET, Conts.GET_ALL_TOP_RATED_TVSERVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("TVRATED", "onResponse: " + jsonObject.getString("name"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getall_toprated_tvseries);
    }

    @Override
    public void GetNowPlayingTVSeries()
    {
        StringRequest getall_now_playing_tvseries = new StringRequest(Request.Method.GET, Conts.GET_NOW_PLAYING_TVSERVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("TV", "onResponse: " + jsonObject.getString("name"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getall_now_playing_tvseries);
    }

    @Override
    public void GetLatestTVSeries()
    {
        JsonObjectRequest getallmovies = new JsonObjectRequest(Request.Method.GET, Conts.GET_LATEST_TVSERVIES,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try
                {
                    String title = response.getString("name");
                    Log.d("LASTEST", "onResponse:  " + title);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }

    @Override
    public void SearchTVSeries(String query)
    {
        StringRequest getsearch_tvseries = new StringRequest(Request.Method.GET, "https://api.themoviedb.org/3/search/tv?api_key="+ MainActivity.myKey +"&language=en-US&query="+query+"&page=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);

                        TVSeries tvSeries = new TVSeries();

                        tvSeries.setName(jsonObject.getString("original_name"));
                        tvSeries.setPoster_path(jsonObject.getString("poster_path"));
                        tvSeries.setBackdrop_path(jsonObject.getString("backdrop_path"));
                        tvSeries.setOverview(jsonObject.getString("overview"));

                        tvSeries.setFirst_air_date(jsonObject.getString("first_air_date"));
                        tvSeries.setVote_average(jsonObject.getInt("vote_average"));
                        tvSeries.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                        SearchTVShows.tvSeriesList.add(tvSeries);

                        Log.d("Original_name", "onResponse: " + jsonObject.getString("original_name"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("first_air_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
                    }

                    SearchTVShows.adapter.notifyDataSetChanged();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getsearch_tvseries);
    }
}
