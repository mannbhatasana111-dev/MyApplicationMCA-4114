package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro11 extends AppCompatActivity {

    private ToggleButton tg1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro11);

        tg1 = findViewById(R.id.toggleButton1);
        btn1 = findViewById(R.id.btnDisplay);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = tg1.isChecked() ? "Status: ON" : "Status: OFF";

                Toast.makeText(UNIT2_pro11.this, status, Toast.LENGTH_SHORT).show();
            }
        });
    }
}