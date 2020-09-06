package com.sudarshan.myapplicationyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse(getIntent().getStringExtra("video"));
        videoView.setVideoURI(uri);
        videoView.start();

    }

}
