package com.was.dicoding.made.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "Movie";
    private String[] dataName;
    private String[] dataRelease;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<MovieList> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent MoveDetail = new Intent(MainActivity.this, MovieDetailActivity.class);
                MovieList movie = movies.get(i);

                Movie dataMovie = new Movie();
                dataMovie.setName(movie.getName());
                dataMovie.setPhoto(movie.getPhoto());
                dataMovie.setRelease(movie.getRelease());
                dataMovie.setDescription(movie.getDescription());


                MoveDetail.putExtra(EXTRA_NAME, dataMovie);
                startActivity(MoveDetail);
            }
        });
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataRelease = getResources().getStringArray(R.array.data_release);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            MovieList movieList = new MovieList();
            movieList.setPhoto(dataPhoto.getResourceId(i, -1));
            movieList.setName(dataName[i]);
            movieList.setRelease(dataRelease[i]);
            movieList.setDescription(dataDescription[i]);
            movies.add(movieList);
        }
        adapter.setMovieLists(movies);
    }
}