package com.tugcearas.simplemoviesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ImageView imageView = findViewById(R.id.imageView);
        TextView movieNameText = findViewById(R.id.movieNameText);
        TextView movieTypeText = findViewById(R.id.movieTypeText);
        TextView moviePointText = findViewById(R.id.moviePointText);


        Intent intent = getIntent();
        String getMovieName = intent.getStringExtra("movieName");
        String getMovieType = intent.getStringExtra("movieType");
        String getmoviePoint = intent.getStringExtra("moviePoints");

        movieNameText.setText(getMovieName);
        movieTypeText.setText(getMovieType);
        moviePointText.setText("imdb: " + getmoviePoint);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());

    }




}