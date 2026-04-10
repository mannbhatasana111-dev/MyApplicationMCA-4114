package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class UNIT4_LIST_PAGE extends AppCompatActivity {

    MaterialCardView pro44, pro45, pro46, pro47, pro48, pro49, pro50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_list_page);

        pro44 = findViewById(R.id.btnPro44);
        pro45 = findViewById(R.id.btnPro45);
        pro46 = findViewById(R.id.btnPro46);
        pro47 = findViewById(R.id.btnPro47);
        pro48 = findViewById(R.id.btnPro48);
        pro49 = findViewById(R.id.btnPro49);
        pro50 = findViewById(R.id.btnPro50);

        pro44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro44.class);
                startActivity(i);
            }
        });

        pro45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro45.class);
                startActivity(i);
            }
        });

        pro46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro46.class);
                startActivity(i);
            }
        });

        pro47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro47.class);
                startActivity(i);
            }
        });

        pro48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro48.class);
                startActivity(i);
            }
        });

        pro49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro49.class);
                startActivity(i);
            }
        });

        pro50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT4_LIST_PAGE.this, UNIT4_pro50.class);
                startActivity(i);
            }
        });

    }
}