package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
// Import CardView instead of Button
import androidx.cardview.widget.CardView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CardView btnUnit1, btnUnit2, btnUnit3, btnUnit4, btnUnit5, btnextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize as CardView
        btnUnit1 = findViewById(R.id.btnUnit1);
        btnUnit2 = findViewById(R.id.btnUnit2);
        btnUnit3 = findViewById(R.id.btnUnit3);
        btnUnit4 = findViewById(R.id.btnUnit4);
        btnUnit5 = findViewById(R.id.btnUnit5);

        // Click listeners work perfectly on CardViews too!
        btnUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UNIT1_LIST_PAGE.class);
                startActivity(i);
            }
        });

        btnUnit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UNIT2_LIST_PAGE.class);
                startActivity(i);
            }
        });

        btnUnit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UNIT3_LIST_PAGE.class);
                startActivity(i);
            }
        });

        btnUnit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UNIT4_LIST_PAGE.class);
                startActivity(i);
            }
        });

        btnUnit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UNIT5_LIST_PAGE.class);
                startActivity(i);
            }
        });

    }
}