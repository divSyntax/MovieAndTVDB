package com.jannahsoftware.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.Model.TVSeries;
import com.jannahsoftware.moviedb.MovieDetails;
import com.jannahsoftware.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularTVAdapter extends RecyclerView.Adapter<PopularTVAdapter.ViewAdapter> {
    private List<TVSeries> tvSeriesList;
    private Context context;
    private boolean isLoaded = false;

    public PopularTVAdapter(List<TVSeries> tvSeries, Context context) {
        this.tvSeriesList = tvSeries;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularTVAdapter.ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View customview = layoutInflater.inflate(R.layout.movies_layout, parent, false);
        ViewAdapter viewAdapter = new ViewAdapter(customview, context);
        return viewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewAdapter holder, final int position)
    {
        final TVSeries tvSeries = tvSeriesList.get(position);

        final String poster = Conts.GET_MOVIE_IMAGES + tvSeries.getPoster_path();
        final String backdropimage = Conts.GET_MOVIE_BACKDROP + tvSeries.getPoster_path();

        holder.title.setText(tvSeries.getName());
        holder.overviewtxt.setText(tvSeries.getOverview());
        holder.releasedate.setText(tvSeries.getFirst_air_date());
        holder.vote_average.setText(String.valueOf(tvSeries.getVote_average()));
        holder.popul_arity.setText(String.valueOf(tvSeries.getPopularity()));

        holder.progressBar.setVisibility(View.VISIBLE);

        if(holder.posterImage != null && holder.backdrop != null)
        {
            isLoaded = true;
            Picasso.get().load(poster).into(holder.posterImage);
            Picasso.get().load(backdropimage).into(holder.backdrop);
        }else
        {
            Picasso.get().load(tvSeries.getPoster_path()).placeholder(R.drawable.ic_launcher_background);
        }

        if(isLoaded == true)
        {
            holder.progressBar.setVisibility(View.INVISIBLE);
        }

        holder.posterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, MovieDetails.class);
                holder.title.setText(tvSeries.getName());
                holder.overviewtxt.setText(tvSeries.getOverview());

                Picasso.get().load(poster).into(holder.posterImage);
                Picasso.get().load(backdropimage).into(holder.backdrop);

                String title = tvSeries.getName();
                String overview = tvSeries.getOverview();
                String releasedate = tvSeries.getFirst_air_date();
                int voteaverage = tvSeries.getVote_average();
                double popularity = tvSeries.getPopularity();

                i.putExtra("title",title);
                i.putExtra("overview", overview);

                i.putExtra("poster",poster);
                i.putExtra("backdrop", backdropimage);

                i.putExtra("releasedate", releasedate);
                i.putExtra("voteaverage",voteaverage);
                i.putExtra("popularity",popularity);



                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return tvSeriesList.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder
    {
        public TextView title, overviewtxt, releasedate, vote_average, popul_arity;
        public ImageView posterImage, backdrop;
        public ProgressBar progressBar;

        public ViewAdapter(@NonNull View itemView, Context ctx)
        {
            super(itemView);

            context = ctx;
            title = itemView.findViewById(R.id.movie_name);
            posterImage = itemView.findViewById(R.id.poster_image);
            backdrop = itemView.findViewById(R.id.backdrop_image);
            overviewtxt = itemView.findViewById(R.id.overview);
            releasedate = itemView.findViewById(R.id.release_date);
            vote_average = itemView.findViewById(R.id.vote_avrage);
            popul_arity = itemView.findViewById(R.id.pop_ularity);
            progressBar = itemView.findViewById(R.id.bar);
        }
    }
}
