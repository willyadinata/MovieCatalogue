package com.was.dicoding.made.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MovieList> movieLists;

    public void setMovieLists(ArrayList<MovieList> movieLists) {
        this.movieLists = movieLists;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movieLists = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieLists.size();
    }

    @Override
    public Object getItem(int i) {
        return movieLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        MovieList movieList = (MovieList) getItem(i);
        viewHolder.bind(movieList);
        return view;
    }
    private class ViewHolder {
        private TextView txtNameMovie;
        private TextView txtReleaseDate;
        private TextView txtDescriptionMovie;
        private ImageView imgPhotoMovie;

        ViewHolder(View view) {
            txtNameMovie = view.findViewById(R.id.tv_name_movie);
            txtReleaseDate = view.findViewById(R.id.tv_release_movie);
            txtDescriptionMovie = view.findViewById(R.id.tv_description_movie);
            imgPhotoMovie = view.findViewById(R.id.img_photo_movie);
        }

        void bind(MovieList movieList) {
            txtNameMovie.setText(movieList.getName());
            txtReleaseDate.setText(movieList.getRelease());
            txtDescriptionMovie.setText(movieList.getDescription());
            imgPhotoMovie.setImageResource(movieList.getPhoto());
        }
    }
}

