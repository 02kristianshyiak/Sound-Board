package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaplayer;
    private Button mPeter;
    private Button mPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPause = findViewById(R.id.pause);
        mPeter = findViewById(R.id.peter);
        mMediaplayer = MediaPlayer.create(this, R.raw.dubstep);

        mPeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaplayer.start();
            }
        });
        mPause.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mMediaplayer.pause();
          }
        });
        mMediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this, "I am done!", Toast.LENGTH_LONG).show();
                releaseMediaPlayer();
            }
        });
    }

    private void releaseMediaPlayer()
    {
        if (mMediaplayer != null)
        {
            mMediaplayer.release();
            mMediaplayer = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        releaseMediaPlayer();
    }
}
