package com.example.ebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioBookActivity extends AppCompatActivity {
    MediaPlayer player;
    static int localPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_book);
        Intent myIntent=getIntent();
        localPosition=myIntent.getIntExtra("index",0);


    }


    public void play(View v){
        String audioUrl=null;
        if(localPosition==0){
            audioUrl = "https://firebasestorage.googleapis.com/v0/b/ebookprototype.appspot.com/o/strip_jack2.mp3?alt=media&token=903807eb-41e6-4f97-ac0b-4497e285e173";
        }
        else if(localPosition==1){
            audioUrl = "https://firebasestorage.googleapis.com/v0/b/ebookprototype.appspot.com/o/the_help2.mp3?alt=media&token=443af3b6-6524-448b-9fce-d5f082bbd55b";
        }
        if(player == null){
            //player = MediaPlayer.create(this,R.raw.tarkan-dudu);
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                player.setDataSource(audioUrl);
                player.prepare();
                player.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
            // below line is use to display a toast message.
            Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();

        }

        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlayer();
            }
        });
    }
    public void pause(View v){
        if(player!=null) player.pause();

    }
    public void stop(View v){
        stopPlayer();
    }

    public void stopPlayer (){
        if(player!=null) {
            player.release();
            player=null;
            Toast.makeText(this, "Media Player released",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}