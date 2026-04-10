package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class UNIT3_pro42 extends AppCompatActivity {

    MaterialButton btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit3_pro42);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        });

        btnStop.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        });
    }
}