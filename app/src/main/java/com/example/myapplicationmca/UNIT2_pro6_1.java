package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro6_1 extends AppCompatActivity {

    TextView tvDisplayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro61);

        // Find the TextView in the XML
        tvDisplayUser = findViewById(R.id.tvDisplayUser);

        String username = getIntent().getStringExtra("key_user");

        if (username != null) {
            tvDisplayUser.setText("Welcome, " + username + "!");
        }
    }
}