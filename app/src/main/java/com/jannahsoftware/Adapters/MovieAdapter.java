package com.jannahsoftware.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
    public void onBindViewHolder(@NonNull MovieAdapter.ViewAdapter holder, int position)
    {
        Movie movies = movieList.get(position);

        String poster = Conts.GET_MOVIE_IMAGES + movies.getPoster_path();
        String backdropimage = Conts.GET_MOVIE_BACKDROP + movies.getPoster_path();

        holder.title.setText(movies.getTitle());

        if(holder.posterImage != null && holder.backdrop != null)
        {
            Picasso.get().load(poster).into(holder.posterImage);
            Picasso.get().load(backdropimage).into(holder.backdrop);
        }else
        {
            Picasso.get().load(movies.getPoster_path()).placeholder(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder
    {
        public TextView title;
        public ImageView posterImage, backdrop;

        public ViewAdapter(@NonNull View itemView, Context ctx)
        {
            super(itemView);

            context = ctx;
            title = itemView.findViewById(R.id.movie_name);
            posterImage = itemView.findViewById(R.id.poster_image);
            backdrop = itemView.findViewById(R.id.backdrop_image);
        }
    }
}
