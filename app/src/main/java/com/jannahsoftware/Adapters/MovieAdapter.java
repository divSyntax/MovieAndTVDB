package com.jannahsoftware.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.moviedb.R;

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
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View customview = layoutInflater.inflate(R.layout.movies_layout, parent, false);
        ViewAdapter viewAdapter = new ViewAdapter(customview, context);
        return viewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewAdapter holder, int position)
    {
        Movie movies = movieList.get(position);

        holder.title.setText(movies.getTitle());
    }

    @Override
    public int getItemCount()
    {
        return movieList.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder
    {
        public TextView title;
        public ImageView posterImage;

        public ViewAdapter(@NonNull View itemView, Context ctx)
        {
            super(itemView);

            context = ctx;
            title = itemView.findViewById(R.id.movie_name);
            posterImage = itemView.findViewById(R.id.poster_image);
        }
    }
}
