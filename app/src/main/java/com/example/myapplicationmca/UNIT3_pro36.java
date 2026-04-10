package com.example.myapplicationmca;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class UNIT3_pro36 extends AppCompatActivity {

    AnimationDrawable frameAnim;
    ImageView imgView;
    ExtendedFloatingActionButton btnToggle;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro36);

        imgView = findViewById(R.id.anim_view);
        btnToggle = findViewById(R.id.btn_toggle);

        // Get the background which is our animation-list XML
        frameAnim = (AnimationDrawable) imgView.getDrawable();

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    frameAnim.start();
                    btnToggle.setText("Stop Animation");
                    btnToggle.setIconResource(android.R.drawable.ic_media_pause);
                    isRunning = true;
                } else {
                    frameAnim.stop();
                    btnToggle.setText("Start Animation");
                    btnToggle.setIconResource(android.R.drawable.ic_media_play);
                    isRunning = false;
                }
            }
        });
    }
}