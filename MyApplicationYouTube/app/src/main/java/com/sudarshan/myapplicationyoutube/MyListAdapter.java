package com.sudarshan.myapplicationyoutube;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;

    public MyListAdapter(Activity context, String[] maintitle,String[] subtitle, Integer[] imgid) {
        super(context, R.layout.layout, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgid=imgid;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.layout, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        @SuppressLint("WrongViewCast") final VideoView videoView = (VideoView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(maintitle[position]);
        final ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4","http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4","http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));

        videoView.setVideoURI(Uri.parse(arrayList.get(position)));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        MediaController mediaController = new MediaController(getContext());
                        videoView.setMediaController(mediaController);
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                return false;
            }
        });
        videoView.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent k = new Intent(getContext(), MainActivity2.class);
                k.putExtra("video",arrayList.get(position));
                getContext().startActivity(k);
                return false;
            }
        });
        //Creating MediaController
        videoView.setVideoURI(Uri.parse(arrayList.get(position)));
        videoView.start();
        subtitleText.setText(subtitle[position]);

        return rowView;

    };
}
