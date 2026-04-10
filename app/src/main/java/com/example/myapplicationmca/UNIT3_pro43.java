package com.example.myapplicationmca;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class UNIT3_pro43 extends AppCompatActivity {

    AudioManager audioManager;

    MaterialButton btnIncrease, btnDecrease, btnNormal, btnVibrate, btnSilent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro43);


        // Initialize AudioManager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Bind Buttons
        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnNormal = findViewById(R.id.btnNormal);
        btnVibrate = findViewById(R.id.btnVibrate);
        btnSilent = findViewById(R.id.btnSilent);

        // Increase Volume
        btnIncrease.setOnClickListener(v -> {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE,
                    AudioManager.FLAG_SHOW_UI);
            Toast.makeText(this, "Volume Increased", Toast.LENGTH_SHORT).show();
        });

        // Decrease Volume
        btnDecrease.setOnClickListener(v -> {
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER,
                    AudioManager.FLAG_SHOW_UI);
            Toast.makeText(this, "Volume Decreased", Toast.LENGTH_SHORT).show();
        });

        // Normal Mode
        btnNormal.setOnClickListener(v -> {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            Toast.makeText(this, "Normal Mode Activated", Toast.LENGTH_SHORT).show();
        });

        // Vibrate Mode
        btnVibrate.setOnClickListener(v -> {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            Toast.makeText(this, "Vibrate Mode Activated", Toast.LENGTH_SHORT).show();
        });

        // Silent Mode
        btnSilent.setOnClickListener(v -> {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            Toast.makeText(this, "Silent Mode Activated", Toast.LENGTH_SHORT).show();
        });
    }
}