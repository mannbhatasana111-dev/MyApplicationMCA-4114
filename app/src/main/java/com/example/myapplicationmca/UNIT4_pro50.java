package com.example.myapplicationmca;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT4_pro50 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro50);

        final VideoView videoView = findViewById(R.id.myVideoView);

        try {
            // Path to res/raw/sample_video.mp4
            String path = "android.resource://" + getPackageName() + "/" + R.raw.sample_video;
            Uri uri = Uri.parse(path);
            videoView.setVideoURI(uri);

            // Create MediaController
            MediaController mediaController = new MediaController(this);
            // This line ensures the controls stick to the VideoView
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);

            // Play only when prepared
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true); // Makes video repeat
                    videoView.start();
                }
            });

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}