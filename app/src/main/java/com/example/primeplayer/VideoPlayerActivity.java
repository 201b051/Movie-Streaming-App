package com.example.primeplayer;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.Collections;

//import com.google.android.exoplayer2.ExoPlayerFactory;
//import com.google.android.exoplayer2.source.ExtractorMediaSource;

public class VideoPlayerActivity extends AppCompatActivity {

    private PlayerView videoPlayer;
    private SimpleExoPlayer simpleExoPlayer;
    private static final String FILE_URL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);

        videoPlayer = findViewById(R.id.exo_player);
        setupExoPlayer(getIntent().getStringExtra("url"));
    }

    private void setupExoPlayer(String url){
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
//        videoPlayer.setPlayer(simpleExoPlayer);
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this,"movieapp"));
//        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url));
//        simpleExoPlayer.prepare(mediaSource);
//        simpleExoPlayer.setPlayWhenReady(true);

        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
        videoPlayer.setPlayer(simpleExoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(url));
        simpleExoPlayer.addMediaItems(Collections.singletonList(mediaItem));
        simpleExoPlayer.prepare();
        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }
}