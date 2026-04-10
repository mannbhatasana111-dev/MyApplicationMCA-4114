package com.example.myapplicationmca;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class UNIT3_pro35 extends AppCompatActivity {

    LinearLayout colorArea;
    TextView tvStatus;
    MaterialCardView cardRed, cardGreen, cardBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro35);

        // Bind views
        colorArea = findViewById(R.id.color_area);
        tvStatus = findViewById(R.id.tv_status);
        cardRed = findViewById(R.id.btnRed);
        cardGreen = findViewById(R.id.btnGreen);
        cardBlue = findViewById(R.id.btnBlue);

        cardRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorArea.setBackgroundColor(Color.parseColor("#FF5252"));
                tvStatus.setText("RED MODE");
                tvStatus.setTextColor(Color.WHITE);
            }
        });

        cardGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorArea.setBackgroundColor(Color.parseColor("#66BB6A"));
                tvStatus.setText("GREEN MODE");
                tvStatus.setTextColor(Color.WHITE);
            }
        });

        cardBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorArea.setBackgroundColor(Color.parseColor("#42A5F5"));
                tvStatus.setText("BLUE MODE");
                tvStatus.setTextColor(Color.WHITE);
            }
        });
    }
}