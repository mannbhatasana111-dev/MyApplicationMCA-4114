package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro20 extends AppCompatActivity {

     RatingBar ratingBar;
     TextView tvRatingValue;
     Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro20);

        ratingBar = findViewById(R.id.ratingBar);
        tvRatingValue = findViewById(R.id.tvRatingValue);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                tvRatingValue.setText("Your Rating: " + rating);
                Toast.makeText(UNIT2_pro20.this, "Submitted Rating: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRatingValue.setText("Rating: " + rating);
            }
        });
    }
}