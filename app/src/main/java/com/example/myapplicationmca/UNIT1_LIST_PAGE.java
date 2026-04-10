package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class UNIT1_LIST_PAGE extends AppCompatActivity {

    // Use MaterialCardView to match your new XML design
    MaterialCardView pro1, pro2, pro3, pro4, pro5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_list_page);

        // 1. Initialize the Cards using the IDs from your new design
        pro1 = findViewById(R.id.btnPro1);
        pro2 = findViewById(R.id.btnPro2);
        pro3 = findViewById(R.id.btnPro3);
        pro4 = findViewById(R.id.btnPro4);
        pro5 = findViewById(R.id.btnPro5);

        // 2. Set Click Listeners using clean Lambda syntax

        // Program 1: Info Toast
        pro1.setOnClickListener(v ->
                Toast.makeText(this, "Task: Installing Android Studio & SDK", Toast.LENGTH_SHORT).show()
        );

        // Program 2: Info Toast
        pro2.setOnClickListener(v ->
                Toast.makeText(this, "Task: Writing your First App", Toast.LENGTH_SHORT).show()
        );

        // Program 3: Navigate to UNIT1_pro3
        pro3.setOnClickListener(v -> {
            Intent intent = new Intent(this, UNIT1_pro3.class);
            startActivity(intent);
        });

        // Program 4: Navigate to UNIT1_pro4
        pro4.setOnClickListener(v -> {
            Intent intent = new Intent(this, UNIT1_pro4.class);
            startActivity(intent);
        });

        // Program 5: Not yet implemented
        pro5.setOnClickListener(v -> {
            Intent intent = new Intent(this, UNIT1_pro5.class);
            startActivity(intent);
        });
    }
}