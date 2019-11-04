package com.jannahsoftware.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageRequest;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.moviedb.MovieDetails;
import com.jannahsoftware.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewAdapter>
{
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View customview = layoutInflater.inflate(R.layout.movies_layout, parent, false);
        ViewAdapter viewAdapter = new ViewAdapter(customview, context);
        return viewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.ViewAdapter holder, int position)
    {
        final Movie movies = movieList.get(position);

        String poster = Conts.GET_MOVIE_IMAGES + movies.getPoster_path();
        final String backdropimage = Conts.GET_MOVIE_BACKDROP + movies.getPoster_path();

        holder.title.setText(movies.getTitle());
        holder.overviewtxt.setText(movies.getOverview());

        if(holder.posterImage != null && holder.backdrop != null)
        {
            Picasso.get().load(poster).into(holder.posterImage);
            Picasso.get().load(backdropimage).into(holder.backdrop);
        }else
        {
            Picasso.get().load(movies.getPoster_path()).placeholder(R.drawable.ic_launcher_background);
        }

        holder.posterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context,MovieDetails.class);
                holder.title.setText(movies.getTitle());
                holder.overviewtxt.setText(movies.getOverview());

                String title = movies.getTitle();
                String overview = movies.getOverview();

                i.putExtra("title",title);
                i.putExtra("overview", overview);

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder
    {
        public TextView title, overviewtxt;
        public ImageView posterImage, backdrop;

        public ViewAdapter(@NonNull View itemView, Context ctx)
        {
            super(itemView);

            context = ctx;
            title = itemView.findViewById(R.id.movie_name);
            posterImage = itemView.findViewById(R.id.poster_image);
            backdrop = itemView.findViewById(R.id.backdrop_image);
            overviewtxt = itemView.findViewById(R.id.overview);
        }
    }
}
