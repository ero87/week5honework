package com.example.ero.week4homework2;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListModel listModel = UserProvider.getUserPosition();

        final TextView largeText = findViewById(R.id.large_text);
        largeText.setText(listModel.getDescription());

        final CollapsingToolbarLayout collaps = findViewById(R.id.toolbar_layout);
        collaps.setTitle(listModel.getTitle());

        final ImageView imageBackground = findViewById(R.id.ifno_image);
        Picasso.get().load(listModel.getImageUrl()[0]).into(imageBackground);


        final RecyclerView recycler = findViewById(R.id.recycler2);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        final InfoAdapter adapter = new InfoAdapter(this, listModel.getImageUrl());
        recycler.setAdapter(adapter);

        setUpVideoView(listModel.getVideoUrl());

        final RatingBar ratingBar = findViewById(R.id.rating_info);
        ratingBar.setRating(listModel.getRating());
    }

    private void setUpVideoView(String url) {
        VideoView video = findViewById(R.id.video);
        video.setVideoURI(Uri.parse(url));
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);
        video.requestFocus();
        video.start();
    }
}
