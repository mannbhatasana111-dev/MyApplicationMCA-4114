package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro25 extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView tvProgressStatus;
    private Button btnStartProgress;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro25);

        progressBar = findViewById(R.id.progressBar);
        tvProgressStatus = findViewById(R.id.tvProgressStatus);
        btnStartProgress = findViewById(R.id.btnStartProgress);

        btnStartProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 1;
                            handler.post(new Runnable() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    tvProgressStatus.setText(progressStatus + "% Complete");
                                }
                            });
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}