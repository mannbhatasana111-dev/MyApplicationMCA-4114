package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro7_1 extends AppCompatActivity {

    TextView tvUserResult, tvPassResult;
    Button btnBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro71);

        tvUserResult = findViewById(R.id.tvUserResult);
        tvPassResult = findViewById(R.id.tvPassResult);
        btnBack = findViewById(R.id.btnBack);


        String u_name = getIntent().getStringExtra("u_name");
        String u_pass = getIntent().getStringExtra("u_pass");

        if (u_name != null && u_pass != null) {
            tvUserResult.setText("Username: " + u_name);
            tvPassResult.setText("Password: " + u_pass);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Closes this screen and goes back
            }
        });
    }
}