package com.was.dicoding.made.moviecatalogue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import static com.was.dicoding.made.moviecatalogue.MainActivity.EXTRA_NAME;

public class MovieDetailActivity extends AppCompatActivity {

    TextView tvName, tvRelease, tvDescription;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        Movie movie = getIntent().getParcelableExtra(EXTRA_NAME);


        tvName = (TextView) findViewById(R.id.tv_movie_title);
        tvRelease = (TextView) findViewById(R.id.tv_release_date);
        tvDescription = (TextView) findViewById(R.id.tv_movie_desc);
        imgPhoto = (ImageView) findViewById(R.id.img_photo_movie);

        tvName.setText(movie.getName());
        tvRelease.setText(movie.getRelease());
        tvDescription.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());
    }
}
