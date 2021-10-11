package com.tugcearas.simplemoviesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listView);

        ArrayList<String> movieName = new ArrayList<>();
        movieName.add("Platform");
        movieName.add("Snowpiercer");
        movieName.add("Harry Potter");
        movieName.add("The Book Thief");
        movieName.add("Zodiac");


        ArrayList<String> movieType = new ArrayList<>();
        movieType.add("Thriller/Horror");
        movieType.add("Science Fiction");
        movieType.add("Fantastic");
        movieType.add("War/Drama");
        movieType.add("Thriller/Mystery");

        ArrayList<String> moviePoints = new ArrayList<>();
        moviePoints.add("7.0");
        moviePoints.add("7.1");
        moviePoints.add("8.0");
        moviePoints.add("7.5");
        moviePoints.add("7.2");



        // images
        Bitmap platform = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.platform);
        Bitmap snowpiercer = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.snowpiercer);
        Bitmap harryPotter = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.harrypotter);
        Bitmap theBookThief = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bookthief);
        Bitmap zodiac = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.zodiac);


        // Transfer images to arraylist
        ArrayList<Bitmap> movieImages = new ArrayList<>();
        movieImages.add(platform);
        movieImages.add(snowpiercer);
        movieImages.add(harryPotter);
        movieImages.add(theBookThief);
        movieImages.add(zodiac);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,movieName);
        listView.setAdapter(adapter);


        // listview clisk
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),MovieDetails.class);

                intent.putExtra("movieName",movieName.get(position));
                intent.putExtra("movieType",movieType.get(position));
                intent.putExtra("moviePoints",moviePoints.get(position));

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(movieImages.get(position));


                startActivity(intent);

            }
        });



    }
}