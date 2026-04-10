package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class UNIT5_LIST_PAGE extends AppCompatActivity {

    // Using MaterialCardView instead of Button to match your new XML
    MaterialCardView pro51, pro52, pro53, pro54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5_list_page);

        // 1. Initialize views with the new IDs from your XML
        pro51 = findViewById(R.id.btnPro51);
        pro52 = findViewById(R.id.btnPro52);
        pro53 = findViewById(R.id.btnPro53);
        pro54 = findViewById(R.id.btnPro54);

        // 2. Set Click Listeners
        pro51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigation logic
                Intent i = new Intent(UNIT5_LIST_PAGE.this, UNIT5_pro51.class);
                startActivity(i);
            }
        });

        pro52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT5_LIST_PAGE.this, UNIT5_pro52.class);
                startActivity(i);
            }
        });

        pro53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT5_LIST_PAGE.this, UNIT5_pro53.class);
                startActivity(i);
            }
        });

        pro54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UNIT5_LIST_PAGE.this, UNIT5_pro54.class);
                startActivity(i);
            }
        });
    }
}